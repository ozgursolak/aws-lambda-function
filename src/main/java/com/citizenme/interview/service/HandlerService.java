package com.citizenme.interview.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.citizenme.interview.constant.Constant;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class HandlerService implements RequestStreamHandler {

    @Override
    public void handleRequest(final InputStream inputStream, final OutputStream outputStream, final Context context)
        throws IOException {

        final LambdaLogger logger = context.getLogger();

        logger.log(context.getFunctionName() + " function is invoked.");

        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        final BufferedReader reader = new BufferedReader(inputStreamReader);
        final PrintWriter writer = new PrintWriter(outputStreamWriter);
        final List<Integer> numbers = new ArrayList<>();

        reader.lines().forEach(line -> {
            final List<String> onlyNumbersString = findIntegers(line);

            if (CollectionUtils.isNotEmpty(onlyNumbersString)) {
                onlyNumbersString.forEach(number -> numbers.add(Integer.valueOf(number)));
            }
        });

        final String result = "{\"output\":" + numbers + "}";

        writer.write(result);

        if (writer.checkError()) {
            logger.log(Constant.writerErrorMessage);
        }

        reader.close();
        writer.close();
    }

    private List<String> findIntegers(final String stringToSearch) {
        if (StringUtils.isEmpty(stringToSearch)) {
            return null;
        }

        final Pattern integerPattern = Pattern.compile(Constant.regexPatternForIntegers);
        final Matcher matcher = integerPattern.matcher(stringToSearch);
        final List<String> integerList = new ArrayList<>();

        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        return integerList;
    }
}