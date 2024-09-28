package com.lehcene.app_bancaire.models;

import com.lehcene.app_bancaire.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Transaction extends AbstractEntity{
    private BigDecimal amount;
    private String destinationIbn;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}


