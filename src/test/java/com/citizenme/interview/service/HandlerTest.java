package com.citizenme.interview.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;

import com.citizenme.interview.constant.TestConstant;
import com.citizenme.interview.model.TestContext;
import com.google.common.io.Files;
import org.junit.jupiter.api.Test;

public class HandlerTest {

    @Test
    public  void testRequestHandler() throws IOException {
        final HandlerService handlerService = new HandlerService();
        final InputStream inputStream = new FileInputStream(TestConstant.testInputFilePath);
        final OutputStream outputStream = new FileOutputStream(TestConstant.testOutputFilePath);
        final Context context = new TestContext();

       handlerService.handleRequest(inputStream, outputStream, context);

        assertTrue(Files.equal(
            new File(TestConstant.expectedTestOutputPath),
            new File(TestConstant.testOutputFilePath)));
    }
}
