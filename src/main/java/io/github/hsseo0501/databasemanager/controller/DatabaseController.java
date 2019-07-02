package io.github.hsseo0501.databasemanager.controller;

import io.github.hsseo0501.databasemanager.model.CommonResponse;
import io.github.hsseo0501.databasemanager.service.QueryExecuteService;
import io.github.hsseo0501.databasemanager.type.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping(value = "/database", produces = MediaType.APPLICATION_JSON_VALUE)
public class DatabaseController {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseController.class);
    private static final String logTitle = "# " + DatabaseController.class.getSimpleName() + ".";

    @Autowired
    QueryExecuteService queryExecuteService;

    @GetMapping()
    public ResponseEntity<?> get(@RequestParam(value = "vendor") String vendor
            , @RequestParam(value = "url") String url
            , @RequestParam(value = "id") String id
            , @RequestParam(value = "password") String password
            , @RequestParam(value = "query") String query) throws Exception {
        String logTitleMethod = logTitle + "get()";

        CommonResponse commonResponse = new CommonResponse();
        try {
            ResultSet resultSet = queryExecuteService.executeQuery(vendor, url, id, password, query);
            List<Object> data = queryExecuteService.convertResultSetToMap(resultSet);
            return ResponseEntity.ok(commonResponse.makeJsonUsingData(ResultCode.SUCCESS, data));
        } catch (Exception e) {
            logger.error(logTitleMethod + e.getMessage());
            return ResponseEntity.badRequest().body(commonResponse.makeJsonUsingMessage(ResultCode.UNDEFINED_EXCEPTION, e.getMessage()));
        }
    }
}
