package tel_ran.jpa.util.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="10_31_Model")
public class Model {
@Id
String modelName;
String vender;
int volume;
@OneToMany(mappedBy="model")
Set<Car> cars;

public Model(){};
public Model(String modelName, String vender, int volume) {
	super();
	this.modelName = modelName;
	this.vender = vender;
	this.volume = volume;
}

public String getModelName() {
	return modelName;
}
public String getVender() {
	return vender;
}
public int getVolume() {
	return volume;
}
public Set<Car> getCars() {
	return cars;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Model other = (Model) obj;
	if (modelName == null) {
		if (other.modelName != null)
			return false;
	} else if (!modelName.equals(other.modelName))
		return false;
	return true;
}
@Override
public String toString() {
	return "Model [modelName=" + modelName + ", vender=" + vender + ", volume=" + volume + "]";
}




}
