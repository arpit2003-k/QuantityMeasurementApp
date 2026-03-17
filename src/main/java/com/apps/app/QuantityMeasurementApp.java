package com.apps.app;

import com.apps.controller.QuantityMeasurementController;
import com.apps.repository.IQuantityMeasurementRepository;
import com.apps.repository.QuantityMeasurementCacheRepository;
import com.apps.service.IQuantityMeasurementService;
import com.apps.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

    	IQuantityMeasurementRepository  repository = QuantityMeasurementCacheRepository.getInstance();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(repository);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        controller.performAddition();
    }

}