package com.nobroker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "owner_plans1")
public class OwnerPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_plan_id")
    private Long ownerPlanId;

    @Column(name = "user_id",unique = true)
    private Long userId;

    @Column(name = "subscription_active")
    private boolean subscriptionActive;

    @Column(name = "subscription_active_date")
    private LocalDate subscriptionActiveDate;

    @Column(name = "subscription_expiration_date")
    private LocalDate subscriptionExpirationDate;

    @Column(name = "number_of_days")
    private int numberOfDays;

    // constructore ,getter and setters

}
