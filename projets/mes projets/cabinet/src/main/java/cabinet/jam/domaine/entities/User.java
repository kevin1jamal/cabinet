package cabinet.jam.domaine.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*Entrez un mail valide")
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Votre mot de passe doit avoir au moin 5 caracteres")
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String name;
    @Column(name = "fonction")
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String fonction;
    @Column(name = "last_name")
    @NotEmpty(message = "*Ce champs est obligatoire")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
