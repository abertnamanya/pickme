package com.pickme.pickme;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.Hibernate;

@MappedSuperclass
public class BasePickMeObject {
	@Column(
			name = "uuid",
			unique = true,
			nullable = false,
			length = 38
	)
	private String uuid = UUID.randomUUID().toString();

	public BasePickMeObject() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int hashCode() {
		return this.getUuid() == null ? super.hashCode() : this.getUuid().hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof BasePickMeObject)) {
			return false;
		} else {
			BasePickMeObject other = (BasePickMeObject)obj;
			if (this.getUuid() == null) {
				return false;
			} else {
				Class<?> thisClass = Hibernate.getClass(this);
				Class<?> objClass = Hibernate.getClass(obj);
				return !thisClass.isAssignableFrom(objClass) && !objClass.isAssignableFrom(thisClass) ? false : this.getUuid().equals(other.getUuid());
			}
		}
	}

	public String toString() {
		return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("hashCode", Integer.toHexString(this.hashCode())).append("uuid", this.getUuid()).build();
	}
	
}
