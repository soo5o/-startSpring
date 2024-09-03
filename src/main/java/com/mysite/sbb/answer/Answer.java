package com.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Set;
import com.mysite.sbb.question.Question;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import com.mysite.sbb.user.SiteUser;
@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	@ManyToOne   //하나의 질문에 여러 답변이 달릴 수 있다.
	private Question question;
	@ManyToOne
    private SiteUser author;
	@ManyToMany
	Set<SiteUser> voter;
}