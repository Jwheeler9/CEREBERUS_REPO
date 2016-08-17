package cerberus.IMS.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="IMS_PURCHASE_ORDER")
public class PurchaseOrder {
	
	//----------------------------------
	// Attributes
	@Id
	@Column(name="ORDER_NUMBER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="purchaseOrderSequence")
	@SequenceGenerator(name="purchaseOrderSequence",sequenceName="PURCHASE_ORDER_SEQUENCE",initialValue=1,allocationSize=1)
	private int orderNumber;

	@Column(name="SUBTOTAL", nullable=false)
	private double subtotal;

	@Column(name="PURCHASE_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate purchaseDate;
	
	@Column(name="TAX_AMOUNT", nullable=false)
	private double taxAmount;

	@Column(name="PO_TOTAL", nullable=false)
	private double poTotal;
	
	//----------------------------------
	// Relationship Mapping
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client client;
	
	@OneToMany(mappedBy="compKey.purchaseOrder")
	private Set<PoLine> lines;
	
	//----------------------------------
	// Accessors
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getPoTotal() {
		return poTotal;
	}
	public void setPoTotal(double poTotal) {
		this.poTotal = poTotal;
	}
	//----------------------------------
	// Constructors
	public PurchaseOrder(){
		super();
	}
	public PurchaseOrder(double subtotal, LocalDate purchaseDate, double taxAmount, double poTotal) {
		this();
		this.subtotal = subtotal;
		this.purchaseDate = purchaseDate;
		this.taxAmount = taxAmount;
		this.poTotal = poTotal;
	}
}
