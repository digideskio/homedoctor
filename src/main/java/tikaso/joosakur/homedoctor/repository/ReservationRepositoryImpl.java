package tikaso.joosakur.homedoctor.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import tikaso.joosakur.homedoctor.domain.Doctor;
import tikaso.joosakur.homedoctor.domain.Reservation;

@Repository
public class ReservationRepositoryImpl implements ReservationRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Reservation> findReservations(int year, int month, int day, Doctor doctor) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reservation> criteriaQuery = criteriaBuilder.createQuery(Reservation.class);
        Root<Reservation> root = criteriaQuery.from(Reservation.class);
        Predicate predicate1 = criteriaBuilder.equal(root.get("doctor").get("id"), doctor.getId());
        Predicate predicate2 = criteriaBuilder.equal(root.get("orderYear"), year);
        Predicate predicate3 = criteriaBuilder.equal(root.get("orderMonth"), month);
        Predicate predicate4 = criteriaBuilder.equal(root.get("orderDay"), day);
        criteriaQuery.where(predicate1, predicate2, predicate3, predicate4);
        TypedQuery<Reservation> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
}
