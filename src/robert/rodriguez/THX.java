package robert.rodriguez;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Arrays;
import java.util.Random;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

/**
 * THX Deep Note Sheet music 
 * https://i.kinja-img.com/gawker-media/image/upload/s--MHW4C38s--/c_scale,f_auto,fl_progressive,q_80,w_800/p2emaasjrbxi4tbhreyr.png
 * @author Jonas
 */
public class THX {

    public static final int SAMPLE_RATE = 128 * 1024; 
    private static double state = 0.0f;
    private static double sign = 1.0f;
    public static final Random random;
    
    static {
        long seed = System.currentTimeMillis();
        random = new Random(seed);
        System.out.println("Generator seed: " + seed);
    }
    
    public static void main(String[] args) throws Exception {
        final AudioFormat af = new AudioFormat(SAMPLE_RATE, 16, 1, true, true);
        SourceDataLine line = AudioSystem.getSourceDataLine(af);
        byte[] tone = generateTHX();
        line.open(af, SAMPLE_RATE);
        line.start();
        System.out.println("Playing");
        play(line, tone);
        line.drain();
        line.close();
        //File out = new File("out.wav");
        //save(tone, af, out);
    }
    
    private static byte[] generateTHX() throws Exception {
        //Frequencies of final chord
        int[] targetchord = {
            1480,1480,1480,
            1175,1175,1175,
            880,880,880,
            587,587,587,
            440,440,440,
            294,294,294,
            220,220,
            147,147,
            110,110,
            73,73,
            55,55
        };
        for (int i = 0; i < 18; i++) {
            double mistake = 0.01;//Controls how out of tune the higher notes are
            targetchord[i] *= 1 + (random.nextDouble() * mistake - (mistake / 2));
        }
        int lineCount = targetchord.length;
        int speed = 4000;//Speed factor
        int min = 200;//Minimum frequency in the random noise section
        int max = 400;//Maximum frequency in the random noise section
        int minSteps = 3;//Minimum amount of different notes played per track in the random noise section
        int maxSteps = 10;//Maximum amount of different notes played per track in the random noise section
        int maxChange = 50;//Maximum frequency difference between each note in the random noise section
        int durationRandom = speed * 3;//Duration of random noise
        int durationTransition = speed * 2;//Duration of transition between random noise and final chord
        int durationHold = speed * 1;//Duration of final chord with increasing volume
        int durationFade = speed * 1;//Duration of final chord with decreasing volume
        double[][] random = new double[lineCount][];
        double[][] chordTransition = new double[lineCount][];
        double[][] chordHold = new double[lineCount][];
        double[][] chordFade = new double[lineCount][];
        int[][] randomWalks = new int[lineCount][];
        for (int i = 0; i < lineCount; i++) {
            int steps = new Random().nextInt(maxSteps - minSteps) + minSteps;
            randomWalks[i] = randomWalk(steps, min, max, maxChange);
        }
        int[][] chordTransitions = new int[lineCount][2];
        for (int i = 0; i < lineCount; i++) {
            chordTransitions[i] = new int[]{randomWalks[i][randomWalks[i].length - 1], targetchord[i]};
        }
        int[][] chordHolds = new int[lineCount][2];
        for (int i = 0; i < lineCount; i++) {
            chordHolds[i] = new int[]{targetchord[i], targetchord[i]};
        }
        for (int i = 0; i < lineCount; i++) {
            System.out.println("Generating voice " + (i + 1) + " / " + lineCount);
            state = -1.0;
            sign = 1.0;
            //Triangle waves sound best
            random[i] = generateTriangle(randomWalks[i], durationRandom);
            chordTransition[i] = generateTriangle(chordTransitions[i], durationTransition);
            chordHold[i] = generateTriangle(chordHolds[i], durationHold);
            chordFade[i] = generateTriangle(chordHolds[i], durationFade);
        }
        System.out.println("Merging voices");
        double[] randomMerged = merge(random);
        double[] chordTransitionMerged = merge(chordTransition);
        double[] chordHoldMerged = merge(chordHold);
        double[] chordFadeMerged = merge(chordFade);
        double[] rising = concat(randomMerged, chordTransitionMerged, chordHoldMerged);
        System.out.println("Adjusting volume");
        changeVolume(chordFadeMerged, 0x7fff, 0);
        changeVolume(rising, 1, 0x7fff);
        double[] dLine = concat(rising, chordFadeMerged);
        System.out.println("Transforming data");
        byte[] line = doubleToBytesUnscaled(dLine);
        return line;
    }
    
    private static void changeVolume(double[] arr, int start, int end) {
        for (int i = 0; i < arr.length; i++) {
            double volume = start + (end - start) * ((double)i / (double)arr.length);
            arr[i] *= volume;
        }
    }
    
    private static byte[] doubleToBytesUnscaled(double[] arr) {
        byte[] data = new byte[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            int masked = (int)arr[i];
            data[i * 2 + 0] = (byte)((masked >> 8) & 0xff);
            data[i * 2 + 1] = (byte)((masked >> 0) & 0xff);
        }
        return data;
    }
    
    private static int[] randomWalk(int steps, int min, int max, int maxChange) {
        int[] arr = new int[steps];
        arr[0] = random.nextInt(max - min) + min;
        for (int i = 1; i < arr.length; i++) {
            int change = random.nextInt(2 * maxChange) - maxChange;
            arr[i] = Math.max(min, Math.min(max, arr[i - 1] + change));
        }
        return arr;
    }
    
    public static double[] concat(double[]... tones) {
        int sum = Arrays.stream(tones).mapToInt(a -> a.length).sum();
        double[] tone = new double[sum];
        int offset = 0;
        for (int i = 0; i < tones.length; i++) {
            System.arraycopy(tones[i], 0, tone, offset, tones[i].length);
            offset += tones[i].length;
        }
        return tone;
    }
    
    public static double[] merge(double[]... tones) {
        int min = Arrays.stream(tones).mapToInt(a -> a.length).min().orElse(0);
        double[] tone = new double[min];
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < tones.length; j++) {
                tone[i] += tones[j][i];
            }
            tone[i] = (tone[i] / tones.length);
        }
        return tone;
    }
    
    public static double[] generateTriangle(int[] freq, int msDuration) {
        double[] sin = new double[SAMPLE_RATE * msDuration / 1000];
        int fac = 1 + sin.length / (freq.length - 1);
        for (int j = 0; j < sin.length; j++) {
            int i = j / fac;
            double f = freq[i] + (freq[i + 1] - freq[i]) * ((double)(j % fac) / (double)fac);
            double period = (double)SAMPLE_RATE / (f * 4);
            state += sign / period;
            if(state > 1.0 || state < -1.0) {
                state = sign;
                sign *= -1;
            }
            sin[j] = state;
        }
        return sin;
    }
    
    public static double[] generateSawtooth(int[] freq, int msDuration) {
        double[] sin = new double[SAMPLE_RATE * msDuration / 1000];
        int fac = 1 + sin.length / (freq.length - 1);
        for (int j = 0; j < sin.length; j++) {
            int i = j / fac;
            double f = freq[i] + (freq[i + 1] - freq[i]) * ((double)(j % fac) / (double)fac);
            double period = (double)SAMPLE_RATE / (2 * f);
            state += 1 / period;
            if(state > 1.0) {
                state = -1.0;
            }
            sin[j] = state;
        }
        return sin;
    }
    
    public static double[] generateSquare(int[] freq, int msDuration) {
        double[] sin = new double[SAMPLE_RATE * msDuration / 1000];
        int fac = 1 + sin.length / (freq.length - 1);
        for (int j = 0; j < sin.length; j++) {
            int i = j / fac;
            double f = freq[i] + (freq[i + 1] - freq[i]) * ((double)(j % fac) / (double)fac);
            double period = (double)SAMPLE_RATE / f;
            state += 2.0 * Math.PI / period;
            double v = Math.sin(state);
            if(v < -0.5) {
                v = -1;
            }
            else if(v > 0.5) {
                v = 1;
            }
            sin[j] = v;
        }
        return sin;
    }
    
    public static double[] generateSine(int[] freq, int msDuration) {
        double[] sin = new double[SAMPLE_RATE * msDuration / 1000];
        int fac = 1 + sin.length / (freq.length - 1);
        for (int j = 0; j < sin.length; j++) {
            int i = j / fac;
            double f = freq[i] + (freq[i + 1] - freq[i]) * ((double)(j % fac) / (double)fac);
            double period = (double)SAMPLE_RATE / f;
            state += 2.0 * Math.PI / period;
            sin[j] = Math.sin(state);
        }
        return sin;
    }
    
    public static void play(SourceDataLine line, byte[] tone) {
        line.write(tone, 0, tone.length);
    }
    
    public static void save(byte[] tone, AudioFormat format, File file) throws Exception{
        ByteArrayInputStream bais = new ByteArrayInputStream(tone);
        AudioInputStream ais = new AudioInputStream(bais, format, tone.length);
        AudioSystem.write(ais, AudioFileFormat.Type.WAVE, file);
    }
}
