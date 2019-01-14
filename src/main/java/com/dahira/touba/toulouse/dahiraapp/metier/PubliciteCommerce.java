package com.dahira.touba.toulouse.dahiraapp.metier;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name ="DAHIRA_PUBLICITE_COMMERCE")
public class PubliciteCommerce implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAHIRA_PUBLICITE_SEQ")
    @GenericGenerator(
            name = "DAHIRA_PUBLICITE_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "DAHIRA_PUBLICITE_SEQ"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")}
    )
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="nature_pub", nullable = false)
    @Size(max=100)
    private String naturePub;

    @Column(name="description_pub", nullable = false)
    @Size(max = 2500)
    private String descriptionPub;

    @Column(name="date_debut_pub", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebPub;

    @Column(name="date_fin_pub")
    @Temporal(TemporalType.DATE)
    private Date dateFinPub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private AppUser appUser;


}
