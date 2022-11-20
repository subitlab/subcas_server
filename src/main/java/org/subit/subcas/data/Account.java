package org.subit.subcas.data;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    @JoinColumn(name = "rid", nullable = false)
    private Role role;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "description")
    private String description;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "is_deleted", nullable = false)
    private Boolean deleted = false;

    @Column(name = "is_activated", nullable = false)
    private Boolean activated = false;

    @Column(name = "is_blocked", nullable = false)
    private Boolean blocked = false;

}
