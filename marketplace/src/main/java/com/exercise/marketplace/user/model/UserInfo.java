package com.exercise.marketplace.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "tb_user")
public class UserInfo {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long user_id;
    
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "privatekey")
    private String privateKey;
}
