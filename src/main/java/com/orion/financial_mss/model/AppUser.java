package com.orion.financial_mss.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Table(name = "AppUser", uniqueConstraints = {@UniqueConstraint(name = "app_user_userName_unique", columnNames = "user_name")})
@Entity(name = "AppUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @SequenceGenerator(
            name = "appUser_sequence",
            sequenceName = "appUser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appUser_sequence"
    )

    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "User Name is mandatory.")
    @Column(name = "user_name", nullable = false, columnDefinition = "TEXT")
    private String userName;

    @NotBlank(message = "Your full name is mandatory.")
    @Column(name = "full_name", nullable = false, columnDefinition = "TEXT")
    private String fullName;

    @NotBlank(message = "The password is mandatory.")
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    public AppUser(String userName, String fullName, String password) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
