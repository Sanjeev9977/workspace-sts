package in.ashok.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_bookers")
public class TicketBookers {
	
	
	public enum Gender { MALE, FEMALE, OTHER }
	public enum TicketStatus { BOOKED, CANCELLED, WAITLISTED, CONFIRMED }


    @Id
    @GeneratedValue(generator = "id_for_ticketbooker")
    @GenericGenerator(name = "id_for_ticketbooker", strategy = "in.ashok.idGenrateor.IrctcCustomerId")
    private String id;

    @Column(unique = true, nullable = false)
    private String ticketId; // Fixed field name
    
    
    
    private String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate journeyDate;
    
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String fromLocation;
    private String toLocation;
    private String trainName;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    // Auto-generate ticketId before saving
    @PrePersist
    public void generateTicketId() {
        this.ticketId = "TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Constructors
    public TicketBookers() {
    }

    public TicketBookers(String name, LocalDate dateOfBirth, LocalDate journeyDate, Gender gender, String fromLocation, String toLocation, String trainName) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.journeyDate = journeyDate;
        this.gender = gender;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.trainName = trainName;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        return "TicketBookers [id=" + id + ", ticketId=" + ticketId + ", name=" + name + ", dateOfBirth=" + dateOfBirth
                + ", journeyDate=" + journeyDate + ", gender=" + gender + ", fromLocation=" + fromLocation
                + ", toLocation=" + toLocation + ", trainName=" + trainName + ", ticketStatus=" + ticketStatus + "]";
    }
}
 