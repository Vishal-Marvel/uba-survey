//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.data.jpa.domain.Specification;
//import java.util.List;
//
//@Service
//public class VillageSurveyService {
//
//    @Autowired
//    private VillageSurveyRepository villageSurveyRepo;
//
//    public List<VillageSurvey> getFilteredSurveys(QueryObject queryObject) {
//        Specification<VillageSurvey> specification = VillageSurveySpecifications.filterByQueryObject(queryObject);
//
//        List<VillageSurvey> sorted = villageSurveyRepo.findAll(specification);
//
//        return sorted;
//    }
//}
