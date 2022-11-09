package core.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="debug")
public class LogDebug extends LogEntity {

}
