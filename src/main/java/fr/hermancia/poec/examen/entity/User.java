package fr.hermancia.poec.examen.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.examen.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(JsonViews.UserListView.class)
    private String name;

    @JsonView(JsonViews.UserListView.class)
    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;


    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String roles;

    private boolean isActive = false;

    @JsonView(JsonViews.UserListView.class)
    @OneToMany(mappedBy = "user")
    private List<Listing> listings = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
