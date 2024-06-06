package com.example.restapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.ToString;

//@ToString
@Entity
@Table(name = "tbl_employee")
// schema: tbl_employee
public class Employee {
//	@JsonProperty("full_name")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//primary key id
	@Column (name = "id")
	private Long id;
	//cac cot name, age, location, email, department
	@Column(name = "name")
	private String name;
//	@JsonIgnore
	@Column(name = "age")
	private long age;
	@Column(name = "location")
	private String location;
	@Column(name = "email")
	private String email;
	@Column(name = "department")
	private String department;

	//get, set, toString
	public Long getId() {return id;
	}
	public void setId(Long id) {this.id = id;
	}
	public String getName() {return name;
	}
	public void setName(String name) {this.name = name;
	}
	public long getAge() {return age;
	}
	public void setAge(long age) {this.age = age;
	}
	public String getLocation() {return location;
	}
	public void setLocation(String location) {this.location = location;
	}
	public String getEmail() {return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {return department;
	}
	public void setDepartment(String department){this.department = department;
	}


	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", location='" + location + '\'' +
				", email='" + email + '\'' +
				", department='" + department + '\'' +
				'}';
	}

}
