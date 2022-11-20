package org.subit.subcas.data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Long cid;

    @Column(name = "redirect_url", nullable = false, unique = true)
    private String redirectUrl;

    @Column(name = "client_id", nullable = false)
    private String clientID;

}
