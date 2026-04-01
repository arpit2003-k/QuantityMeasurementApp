package com.app.quantitymeasurement.service;



import java.util.List;

import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.dto.QuantityMeasurementDTO;

public interface IQuantityMeasurementService {

    // ===== Core Operations =====

    QuantityMeasurementDTO compare(QuantityInputDTO input);

    QuantityMeasurementDTO convert(QuantityInputDTO input);

    QuantityMeasurementDTO add(QuantityInputDTO input);

    QuantityMeasurementDTO subtract(QuantityInputDTO input);

    QuantityMeasurementDTO divide(QuantityInputDTO input);
    
    QuantityMeasurementDTO multiply(QuantityInputDTO quantityInputDTO);

    // ===== History & Reporting =====

    // Get history of all measurements by operation type
    List<QuantityMeasurementDTO> getHistoryByOperation(String operation);

    // Get history of all measurements by measurement type
    List<QuantityMeasurementDTO> getHistoryByMeasurementType(String measurementType);

    // Get count of successful operations by operation type
    long getOperationCount(String operation);

    // Get all errored measurements
    List<QuantityMeasurementDTO> getErrorHistory();

}