package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="User")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class UserEntity 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer user_id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    ShopEntity shop;

    @ManyToOne
    @JoinColumn(name = "area_id")
    AreaEntity area;

    @Column(length=15)
    String user_name;

    @Column(length=10)
    String password;

    @Column(length=50)
    String email;

    @Column(length=20)
    String phoneNo;

    @Column(length=15)
    String seqQue;

    @Column(length=15)
    String seqAns;

}
