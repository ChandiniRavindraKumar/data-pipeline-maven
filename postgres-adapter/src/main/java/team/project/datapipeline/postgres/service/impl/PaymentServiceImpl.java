package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Payment;
import team.project.datapipeline.postgres.repository.PaymentRepository;
import team.project.datapipeline.postgres.service.PaymentService;

import java.util.Objects;
import java.util.Optional;

@Service
class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Iterable<Payment> findAll() {
        return paymentRepository.findAll();
    }
    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> find(Integer paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public Payment update(Payment payment) throws Exception {

        if (Objects.isNull(payment.getPaymentId())) {
            throw new Exception("Payment id is mandatory for the update operation");
        }

        Payment updatedPayment = null;
        Payment staticAmount = new Payment();

        Optional<Payment> existingPaymentOpt = paymentRepository.findById(payment.getPaymentId());

        if (existingPaymentOpt.isPresent()) {
            Payment existingPayment = existingPaymentOpt.get();

            if (!payment.getAmount().equals(existingPayment.getAmount())) {
                existingPayment.setAmount(staticAmount.getAmount());
            }

            updatedPayment = paymentRepository.save(existingPayment);
        } else {
            throw new Exception("Payment is not found in the database");
        }

        return updatedPayment;
    }
}
