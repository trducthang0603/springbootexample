package cleancode.v1.model.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@Getter
@Setter
public abstract class DateAudit implements Serializable {
    @Column(nullable = false,updatable = false)
    private Instant createAt   = Instant.now();;

    @Column(nullable = false)
    private  Instant updateAt  = Instant.now();;
    @PrePersist
    protected void onCreate() {
        this.createAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateAt = Instant.now();
    }
}
