package team.project.dataadaptor.datapelinepostgres.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Calendar;


@Entity
@Table(name="actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long actorId;
    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="lastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public Actor() {

    }

    public Actor(String firstName, String lastName, Date lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public String toString() {
        return "Actor[actorId=" + actorId +", firstName=" + firstName + ", lastname=" + lastName +", lastUpdate=" + lastUpdate + "]";
    }



}
