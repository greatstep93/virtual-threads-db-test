package ru.greatstep.virtualthreadsdbtest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.greatstep.virtualthreadsdbtest.models.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByClientClientCode(String clientCode);

    @Query(nativeQuery = true, value = """
            SELECT o.id, order_number,client_id, full_name, client_code FROM orders o
            INNER JOIN public.client c on c.id = o.client_id
            WHERE c.client_code = :clientCode
            """)
    List<Order> findAllByClientClientCodeNative(String clientCode);

}
