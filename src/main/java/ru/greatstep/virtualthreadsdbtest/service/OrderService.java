package ru.greatstep.virtualthreadsdbtest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.greatstep.virtualthreadsdbtest.mapper.OrderMapper;
import ru.greatstep.virtualthreadsdbtest.models.dto.Response;
import ru.greatstep.virtualthreadsdbtest.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional(propagation = Propagation.NEVER)
    public Response findOrders(String clientCode) {
        return orderMapper.toResponse(orderRepository.findAllByClientClientCode(clientCode));
//        return orderMapper.toResponse(orderRepository.findAllByClientClientCodeNative(clientCode));
    }

}
