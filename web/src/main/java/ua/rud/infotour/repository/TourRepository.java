package ua.rud.infotour.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.rud.infotour.domain.Tour;

import java.util.List;
import java.util.UUID;

@Repository
public interface TourRepository extends JpaRepository<Tour, UUID> {

    @EntityGraph(value = "tourWithSchedulesAndPeople", type = EntityGraph.EntityGraphType.LOAD)
    Tour getById(UUID id);

//    @EntityGraph(value = "tourWithSchedulesAndPeople", type = EntityGraph.EntityGraphType.LOAD)

//    @Query(value = "select tour " +
//            "from Tour tour " +
//            "left join fetch tour.people " +
//            "left join fetch tour.events " +
//            "left join fetch tour.revisions")
    @EntityGraph(value = "tourWithSchedulesAndPeople", type = EntityGraph.EntityGraphType.LOAD)

    List<Tour> findAll();
}
