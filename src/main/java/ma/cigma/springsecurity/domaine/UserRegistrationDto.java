package ma.cigma.springsecurity.domaine;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cigma.springsecurity.constraint.FieldMatch;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
})


@Data
@NoArgsConstructor
public class UserRegistrationDto {
    @NotEmpty
    private String nom;

    @NotEmpty
    private String prenom;

    @NotEmpty
    private String adresse;
    
    @NotEmpty
    private String ville;
    
    @NotEmpty
    private String tel;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;


    @AssertTrue
    private Boolean terms;

}
