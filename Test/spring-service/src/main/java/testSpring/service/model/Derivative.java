package testSpring.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "derivative",uniqueConstraints = {@UniqueConstraint(columnNames = "deri_composite_code")})
public class Derivative {

    private String deri_composite_code;
    private String derivative_code;
    private Date effective_date;
    private Date expiration_date;
    private Date created_date;
    private String created_by;
    private Date modified_date;
    private String modified_by;
    private String underlying_type;

    public Derivative() {
    }

    public Derivative(String deri_composite_code, String derivative_code, Date effective_date, Date expiration_date, Date created_date, String created_by, Date modified_date, String modified_by, String underlying_type) {
        this.deri_composite_code = deri_composite_code;
        this.derivative_code = derivative_code;
        this.effective_date = effective_date;
        this.expiration_date = expiration_date;
        this.created_date = created_date;
        this.created_by = created_by;
        this.modified_date = modified_date;
        this.modified_by = modified_by;
        this.underlying_type = underlying_type;
    }

    @Id
    @Column(name = "deri_composite_code",unique = true,nullable = false)
    public String getDeri_composite_code() {
        return deri_composite_code;
    }

    public void setDeri_composite_code(String deri_composite_code) {
        this.deri_composite_code = deri_composite_code;
    }

    @Column(name = "derivative_code", nullable = false)
    public String getDerivative_code() {
        return derivative_code;
    }

    public void setDerivative_code(String derivative_code) {
        this.derivative_code = derivative_code;
    }

    @Column(name = "effective_date", nullable = false)
    public Date getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(Date effective_date) {
        this.effective_date = effective_date;
    }

    @Column(name = "expiration_date", nullable = false)
    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Column(name = "created_date", nullable = false)
    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Column(name = "created_by", nullable = false)
    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    @Column(name = "modified_date", nullable = false)
    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    @Column(name = "modified_by", nullable = false)
    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    @Column(name = "underlying_type", nullable = false)
    public String getUnderlying_type() {
        return underlying_type;
    }

    public void setUnderlying_type(String underlying_type) {
        this.underlying_type = underlying_type;
    }
}
