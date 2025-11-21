package com.example.nov21.entity;

import org.springframework.data.annotation.Id;

// import com.fasterxml.jackson.annotation.JsonBackReference;

/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
*/
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// @Entity
// @Table(name = "passengers")
public class Passenger {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private Long bookingId; // foreign key from booking entity
    
    @NotBlank
    private String name;    
    @NotBlank
    private String gender;  
    @Min(value = 0)
    private Integer age;    
    @NotBlank
    private String seatNumber;

    // Relationship to Booking Entity (Many Passengers belong to One Booking)
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "pnr_fk", nullable = false) 
    // @JsonBackReference
    // private Booking booking; // stores pnr as foreign key from passengers table

    public Passenger() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	/*public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}*/
	

}
