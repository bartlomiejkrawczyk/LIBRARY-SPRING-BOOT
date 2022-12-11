package com.example.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ISSUES")
public class Issue {

	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true, precision = 9)
	private Integer id;

	@Column(nullable = false, length = 13)
	private String isbn;

	@Column(precision = 8)
	private Integer userId;

	private Timestamp bookBorrowDate;
}
