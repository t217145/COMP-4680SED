package comp4680.u04.app03;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "tbl_accounts")
@Data
@ToString
public class Account implements Serializable {
    public Account(String accountNo, char type, double balance, Customers customer) {
        this.accountNo = accountNo;
        this.type = type;
        this.balance = balance;
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AccountNo", nullable = false, length = 255)
    private String accountNo;

    private char type;

    private double balance;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customers customer;
}