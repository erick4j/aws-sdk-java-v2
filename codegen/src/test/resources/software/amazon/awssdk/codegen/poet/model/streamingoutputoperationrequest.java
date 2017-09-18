package software.amazon.awssdk.services.jsonprotocoltests.model;

import java.util.Optional;
import javax.annotation.Generated;
import software.amazon.awssdk.AmazonWebServiceRequest;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

@Generated("software.amazon.awssdk:codegen")
public class StreamingOutputOperationRequest extends AmazonWebServiceRequest implements
        ToCopyableBuilder<StreamingOutputOperationRequest.Builder, StreamingOutputOperationRequest> {
    private StreamingOutputOperationRequest(BuilderImpl builder) {
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof StreamingOutputOperationRequest)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("}");
        return sb.toString();
    }

    public <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        default:
            return Optional.empty();
        }
    }

    public interface Builder extends CopyableBuilder<Builder, StreamingOutputOperationRequest> {
    }

    private static final class BuilderImpl implements Builder {
        private BuilderImpl() {
        }

        private BuilderImpl(StreamingOutputOperationRequest model) {
        }

        @Override
        public StreamingOutputOperationRequest build() {
            return new StreamingOutputOperationRequest(this);
        }
    }
}
