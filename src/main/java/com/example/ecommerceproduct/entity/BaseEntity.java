package com.example.ecommerceproduct.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @Setter(AccessLevel.NONE)
    private ZonedDateTime createdDate;

    @Column(name = "modified_date", nullable = false)
    @LastModifiedDate
    @Setter(AccessLevel.NONE)
    private ZonedDateTime modifiedDate;

}
