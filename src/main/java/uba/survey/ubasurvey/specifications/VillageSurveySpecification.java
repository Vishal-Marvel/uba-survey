package uba.survey.ubasurvey.specifications;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import uba.survey.ubasurvey.DTO.ExcelQueryObject;
import uba.survey.ubasurvey.entity.villageSurvey.VillageSurvey;

import java.util.ArrayList;
import java.util.List;

public class VillageSurveySpecification {

    public static Specification<VillageSurvey> filterByQueryObject(ExcelQueryObject excelQueryObject) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Add conditions based on non-null fields in QueryObject
            if (excelQueryObject.getSurveyorNames() != null && !excelQueryObject.getSurveyorNames().isEmpty()) {
                predicates.add(root.get("surveyorName").in(excelQueryObject.getSurveyorNames()));
            }

            if (excelQueryObject.getFromDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateOfSurvey"), excelQueryObject.getFromDate()));
            }

            if (excelQueryObject.getToDate() != null) {
                excelQueryObject.getToDate().setTime(excelQueryObject.getToDate().getTime() + (1000 * 60 * 60 * 24));

                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateOfSurvey"), excelQueryObject.getToDate()));
            }

            if (excelQueryObject.getVillages() != null && !excelQueryObject.getVillages().isEmpty()) {
                predicates.add(root.get("nameOfTheVillage").in(excelQueryObject.getVillages()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
