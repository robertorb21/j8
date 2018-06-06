package robert.rodriguez;

import java.util.Date;

public class Transaction implements Comparable<Transaction>{
	private Long idTr;
	private String name;
	private Integer concept;
	private Integer cat;
	private Date date;
	private Double amnt;
	private Integer splitRegister;
	private Long idSplit;
	private Integer idImage;
	private Integer visits;
	private Double averageExpenditure;
	private Double totalCost;
	private Integer splitCreated;
	private Integer ingressExpense;
	private Integer mcc;
	private int movementType;
	private int operationStatus;
	private String typeCurrency;
	private String type;
	private Double percentage;

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIdTr() {
		return idTr;
	}

	public void setIdTr(Long idTr) {
		this.idTr = idTr;
	}

	public int getMovementType() {
		return movementType;
	}

	public void setMovementType(int movementType) {
		this.movementType = movementType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getConcept() {
		return concept;
	}

	public void setConcept(Integer concept) {
		this.concept = concept;
	}

	public Integer getCat() {
		return cat;
	}

	public void setCat(Integer cat) {
		this.cat = cat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmnt() {
		return amnt;
	}

	public void setAmnt(Double amnt) {
		this.amnt = amnt;
	}

	public Integer getSplitRegister() {
		return splitRegister;
	}

	public void setSplitRegister(Integer splitRegister) {
		this.splitRegister = splitRegister;
	}

	public Long getIdSplit() {
		return idSplit;
	}

	public void setIdSplit(Long idSplit) {
		this.idSplit = idSplit;
	}

	public Integer getIdImage() {
		return idImage;
	}

	public void setIdImage(Integer idImage) {
		this.idImage = idImage;
	}

	public Integer getVisits() {
		return visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public Double getAverageExpenditure() {
		return averageExpenditure;
	}

	public void setAverageExpenditure(Double averageExpenditure) {
		this.averageExpenditure = averageExpenditure;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getSplitCreated() {
		return splitCreated;
	}

	public void setSplitCreated(Integer splitCreated) {
		this.splitCreated = splitCreated;
	}

	public Integer getIngressExpense() {
		return ingressExpense;
	}

	public void setIngressExpense(Integer ingressExpense) {
		this.ingressExpense = ingressExpense;
	}

	public Integer getMcc() {
		return mcc;
	}

	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}

	public int getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(int operationStatus) {
		this.operationStatus = operationStatus;
	}

	public String getTypeCurrency() {
		return typeCurrency;
	}

	public void setTypeCurrency(String typeCurrency) {
		this.typeCurrency = typeCurrency;
	}

	@Override
	public int compareTo(Transaction tx) {
		
		int compareDate = ((Transaction) tx).getDate().before(this.date) ? 1 : 0;
		
		return compareDate;
	}

}

