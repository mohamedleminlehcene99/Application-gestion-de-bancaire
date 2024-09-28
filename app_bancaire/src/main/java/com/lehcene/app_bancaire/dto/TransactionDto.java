package com.lehcene.app_bancaire.dto;

import com.lehcene.app_bancaire.enums.TransactionType;
import com.lehcene.app_bancaire.models.Transaction;
import com.lehcene.app_bancaire.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Integer id;
    @Positive(message = "Le montant doit etre valeur positive.")
    private BigDecimal amount;
    private String destinationIbn;
    private TransactionType transactionType;
    private Integer userId;

    public static TransactionDto fromEntity(Transaction transaction){
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .transactionType(transaction.getTransactionType())
                .destinationIbn(transaction.getDestinationIbn())
                .userId(transaction.getUser().getId())
                .build();
    }

    public static Transaction toEntity(TransactionDto transactionDto){
        return Transaction.builder()
                .id(transactionDto.getId())
                .amount(transactionDto.getAmount())
                .destinationIbn(transactionDto.getDestinationIbn())
                .transactionType(transactionDto.getTransactionType())
                .user(User.builder().id(transactionDto.getUserId()).build())
                .build();
    }

}
