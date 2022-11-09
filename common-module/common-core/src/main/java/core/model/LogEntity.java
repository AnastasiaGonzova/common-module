package core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class LogEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private Long systemTypeId;
    private String params;
}
