/*
 * Copyright 2010-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.internal.http.response;

import software.amazon.awssdk.AmazonServiceException;
import software.amazon.awssdk.http.HttpResponse;
import software.amazon.awssdk.http.HttpResponseHandler;
import software.amazon.awssdk.interceptor.ExecutionAttributes;

public class NullErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {

    @Override
    public AmazonServiceException handle(HttpResponse response,
                                         ExecutionAttributes executionAttributes) throws Exception {
        return new AmazonServiceException(null);
    }

    @Override
    public boolean needsConnectionLeftOpen() {
        return false;
    }

}
