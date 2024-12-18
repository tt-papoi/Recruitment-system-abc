package com.learnthepath.recruitmentsystemabc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recruitments")
public class RecruitmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_id")
    private Integer id;

    @Column(name = "applied_position", nullable = false)
    private String appliedPosition;

    @Column(name = "requirements", nullable = false, columnDefinition = "TEXT")
    private String requirements;

    @Column(name = "job_description", nullable = false, columnDefinition = "TEXT")
    private String jobDescription;

    @Column(name = "number_candidates", nullable = false)
    private Integer numberCandidates;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "disapproval_reason", length = 1000)
    private String disapprovalReason;

    @Column(name = "end_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "work_location", nullable = false)
    private String workLocation;

    @Column(name = "work_experience", nullable = false)
    private String workExperience;

    @Column(name = "benefits", nullable = false,
            columnDefinition = "TEXT")
    private String benefits;

    @Column(name = "salary", nullable = false)
    private String salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id", nullable = false)
    private EnterpriseEntity enterprise;

    @OneToOne(mappedBy = "recruitment")
    InvoiceEntity invoiceEntity;

    @OneToMany(mappedBy = "recruitment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResumeEntity> resumes = new HashSet<>();
}
