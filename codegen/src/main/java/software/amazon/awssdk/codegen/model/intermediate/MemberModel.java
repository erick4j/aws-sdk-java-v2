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

package software.amazon.awssdk.codegen.model.intermediate;

import static software.amazon.awssdk.codegen.internal.Constants.LF;
import static software.amazon.awssdk.codegen.internal.DocumentationUtils.DEFAULT_FLUENT_RETURN;
import static software.amazon.awssdk.codegen.internal.DocumentationUtils.DEFAULT_GETTER;
import static software.amazon.awssdk.codegen.internal.DocumentationUtils.DEFAULT_GETTER_PARAM;
import static software.amazon.awssdk.codegen.internal.DocumentationUtils.DEFAULT_SETTER;
import static software.amazon.awssdk.codegen.internal.DocumentationUtils.DEFAULT_SETTER_PARAM;
import static software.amazon.awssdk.codegen.internal.DocumentationUtils.stripHtmlTags;
import static software.amazon.awssdk.utils.StringUtils.upperCase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.codegen.internal.TypeUtils;
import software.amazon.awssdk.protocol.MarshallingInfo;
import software.amazon.awssdk.runtime.transform.PathMarshallers;
import software.amazon.awssdk.utils.StringUtils;

public class MemberModel extends DocumentationModel {

    private String name;

    private String c2jName;

    private String c2jShape;

    private VariableModel variable;

    private VariableModel setterModel;

    private ReturnTypeModel getterModel;

    private ParameterHttpMapping http;

    private boolean deprecated;

    private ListModel listModel;

    private MapModel mapModel;

    private String enumType;

    private String xmlNameSpaceUri;

    private boolean idempotencyToken;

    private ShapeModel shape;

    private String fluentGetterMethodName;

    private String fluentSetterMethodName;

    private String beanStyleGetterName;

    private String beanStyleSetterName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberModel withName(String name) {
        setName(name);
        return this;
    }

    public String getC2jName() {
        return c2jName;
    }

    public void setC2jName(String c2jName) {
        this.c2jName = c2jName;
    }

    public MemberModel withC2jName(String c2jName) {
        setC2jName(c2jName);
        return this;
    }

    public String getC2jShape() {
        return c2jShape;
    }

    public void setC2jShape(String c2jShape) {
        this.c2jShape = c2jShape;
    }

    public MemberModel withC2jShape(String c2jShape) {
        setC2jShape(c2jShape);
        return this;
    }

    public VariableModel getVariable() {
        return variable;
    }

    public void setVariable(VariableModel variable) {
        this.variable = variable;
    }

    public MemberModel withVariable(VariableModel variable) {
        setVariable(variable);
        return this;
    }

    public VariableModel getSetterModel() {
        return setterModel;
    }

    public void setSetterModel(VariableModel setterModel) {
        this.setterModel = setterModel;
    }

    public MemberModel withSetterModel(VariableModel setterModel) {
        setSetterModel(setterModel);
        return this;
    }

    public String getFluentGetterMethodName() {
        return fluentGetterMethodName;
    }

    public void setFluentGetterMethodName(String fluentGetterMethodName) {
        this.fluentGetterMethodName = fluentGetterMethodName;
    }

    public MemberModel withFluentGetterMethodName(String getterMethodName) {
        setFluentGetterMethodName(getterMethodName);
        return this;
    }

    public String getBeanStyleGetterMethodName() {
        return beanStyleGetterName;
    }

    public void setBeanStyleGetterMethodName(String beanStyleGetterName) {
        this.beanStyleGetterName = beanStyleGetterName;
    }

    public MemberModel withBeanStyleGetterMethodName(String beanStyleGetterName) {
        this.beanStyleGetterName = beanStyleGetterName;
        return this;
    }

    public String getBeanStyleSetterMethodName() {
        return beanStyleSetterName;
    }

    public void setBeanStyleSetterMethodName(String beanStyleSetterName) {
        this.beanStyleSetterName = beanStyleSetterName;
    }

    public MemberModel withBeanStyleSetterMethodName(String beanStyleSetterName) {
        this.beanStyleSetterName = beanStyleSetterName;
        return this;
    }

    // TODO: Remove when all marshallers switch over to new style
    public String getSetterMethodName() {
        return getBeanStyleSetterMethodName();
    }

    // TODO: Remove when all marshallers switch over to new style
    public void setSetterMethodName(String setterMethodName) {
        setBeanStyleGetterMethodName(setterMethodName);
    }

    // TODO: Remove when all marshallers switch over to new style
    public MemberModel withSetterMethodName(String setterMethodName) {
        setSetterMethodName(setterMethodName);
        return this;
    }

    public String getFluentSetterMethodName() {
        return fluentSetterMethodName;
    }

    public void setFluentSetterMethodName(String fluentSetterMethodName) {
        this.fluentSetterMethodName = fluentSetterMethodName;
    }

    public MemberModel withFluentSetterMethodName(String fluentMethodName) {
        setFluentSetterMethodName(fluentMethodName);
        return this;
    }

    public ReturnTypeModel getGetterModel() {
        return getterModel;
    }

    public void setGetterModel(ReturnTypeModel getterModel) {
        this.getterModel = getterModel;
    }

    public MemberModel withGetterModel(ReturnTypeModel getterModel) {
        setGetterModel(getterModel);
        return this;
    }

    public ParameterHttpMapping getHttp() {
        return http;
    }

    public void setHttp(ParameterHttpMapping parameterHttpMapping) {
        this.http = parameterHttpMapping;
    }

    public boolean isSimple() {
        return TypeUtils.isSimple(variable.getVariableType());
    }

    public boolean isList() {
        return listModel != null;
    }

    public boolean isMap() {
        return mapModel != null;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated;
    }

    public ListModel getListModel() {
        return listModel;
    }

    public void setListModel(ListModel listModel) {
        this.listModel = listModel;
    }

    public MapModel getMapModel() {
        return mapModel;
    }

    public MemberModel withListModel(ListModel list) {
        setListModel(list);
        return this;
    }

    public void setMapModel(MapModel map) {
        this.mapModel = map;
    }

    public MemberModel withMapModel(MapModel map) {
        setMapModel(map);
        return this;
    }

    public String getEnumType() {
        return enumType;
    }

    public void setEnumType(String enumType) {
        this.enumType = enumType;
    }

    public MemberModel withEnumType(String enumType) {
        setEnumType(enumType);
        return this;
    }

    public String getXmlNameSpaceUri() {
        return xmlNameSpaceUri;
    }

    public void setXmlNameSpaceUri(String xmlNameSpaceUri) {
        this.xmlNameSpaceUri = xmlNameSpaceUri;
    }

    public MemberModel withXmlNameSpaceUri(String xmlNameSpaceUri) {
        setXmlNameSpaceUri(xmlNameSpaceUri);
        return this;
    }

    public String getSetterDocumentation() {
        StringBuilder docBuilder = new StringBuilder();

        docBuilder.append(StringUtils.isNotBlank(documentation) ? documentation : DEFAULT_SETTER.replace("%s", name) + "\n");

        if (ByteBuffer.class.getName().equals(this.getGetterModel().getReturnType())) {
            appendParagraph(docBuilder, "To preserve immutability, the remaining bytes in the provided buffer will be copied "
                                        + "into a new buffer when set.");
        }

        docBuilder.append(getParamDoc())
                .append(getEnumDoc());

        return docBuilder.toString();
    }

    public String getGetterDocumentation() {
        String returnType = this.getGetterModel().getReturnType();
        StringBuilder docBuilder = new StringBuilder();
        docBuilder.append(StringUtils.isNotBlank(documentation) ? documentation : DEFAULT_GETTER.replace("%s", name))
                .append(LF);

        if (returnType != null) {
            if (returnType.equals(ByteBuffer.class.getName())) {
                appendParagraph(docBuilder,
                                "This method will return a new read-only {@code ByteBuffer} each time it is invoked.");
            }

            if (returnType.startsWith(List.class.getName()) || returnType.startsWith(Map.class.getName())) {
                appendParagraph(docBuilder, "Attempts to modify the collection returned by this method will result in an "
                                            + "UnsupportedOperationException.");
            }
        }

        String variableDesc = StringUtils.isNotBlank(documentation) ? documentation : DEFAULT_GETTER_PARAM.replace("%s", name);

        docBuilder.append("@return ")
                  .append(stripHtmlTags(variableDesc))
                  .append(getEnumDoc());

        return docBuilder.toString();
    }

    public String getFluentSetterDocumentation() {
        StringBuilder docBuilder = new StringBuilder();
        docBuilder.append(getSetterDocumentation())
                .append(LF)
                .append("@return " + stripHtmlTags(DEFAULT_FLUENT_RETURN))
                .append(getEnumDoc());
        return docBuilder.toString();
    }

    private String getParamDoc() {
        StringBuilder docBuilder = new StringBuilder();

        String variableDesc = StringUtils.isNotBlank(documentation) ? documentation : DEFAULT_SETTER_PARAM.replace("%s", name);

        docBuilder.append(LF)
                  .append("@param ")
                  .append(variable.getVariableName())
                  .append(" ")
                  .append(stripHtmlTags(variableDesc));
        return docBuilder.toString();
    }

    private String getEnumDoc() {
        StringBuilder docBuilder = new StringBuilder();

        if (enumType != null) {
            docBuilder.append(LF);
            docBuilder.append("@see " + enumType);
        }

        return docBuilder.toString();
    }

    public boolean isIdempotencyToken() {
        return idempotencyToken;
    }

    public void setIdempotencyToken(boolean idempotencyToken) {
        this.idempotencyToken = idempotencyToken;
    }

    public boolean getIsBinary() {
        return http.getIsStreaming() || (http.getIsPayload() && "java.nio.ByteBuffer".equals(variable.getVariableType()));
    }

    /**
     * @return Implementation of {@link software.amazon.awssdk.transform.PathMarshallers.PathMarshaller} to use if this
     *     member is bound the the URI.
     * @throws IllegalStateException If this member is not bound to the URI. Templates should first check
     *     {@link ParameterHttpMapping#isUri()} first.
     */
    @JsonIgnore
    public String getPathMarshaller() {
        if (!http.isUri()) {
            throw new IllegalStateException("Only members bound to the URI have a path marshaller");
        }
        final String prefix = PathMarshallers.class.getName();
        if (http.isGreedy()) {
            return prefix + ".GREEDY";
        } else if (isIdempotencyToken()) {
            return prefix + ".IDEMPOTENCY";
        } else {
            return prefix + ".NON_GREEDY";
        }
    }

    /**
     * Used for JSON services. Name of the field containing the {@link MarshallingInfo} for
     * this member.
     */
    @JsonIgnore
    public String getMarshallerBindingFieldName() {
        return upperCase(this.name) + "_BINDING";
    }

    @JsonIgnore
    public boolean hasBuilder() {
        return !(isSimple() || isList() || isMap());
    }

    @JsonIgnore
    public boolean isCollectionWithBuilderMember() {
        return (isList() && getListModel().getListMemberModel() != null && getListModel().getListMemberModel().hasBuilder()) ||
               (isMap() && getMapModel().getValueModel() != null && getMapModel().getValueModel().hasBuilder());
    }

    /**
     * Currently used only for JSON services.
     *
     * @return Marshalling type to use when creating a {@link MarshallingInfo}. Must be a field of {@link
     * software.amazon.awssdk.protocol.MarshallingType}.
     */
    public String getMarshallingType() {
        if (isList()) {
            return "LIST";
        } else if (isMap()) {
            return "MAP";
        } else if (!isSimple()) {
            return "STRUCTURED";
        } else {
            return TypeUtils.getMarshallingType(variable.getSimpleType());
        }
    }

    /**
     * Currently used only for JSON services.
     *
     * @return The target class a marshalling type is bound to.
     */
    public String getMarshallingTargetClass() {
        if (isList()) {
            return "List";
        } else if (isMap()) {
            return "Map";
        } else if (!isSimple()) {
            return "StructuredPojo";
        } else {
            return variable.getVariableType();
        }
    }

    @JsonIgnore
    public ShapeModel getShape() {
        return shape;
    }

    public void setShape(ShapeModel shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return c2jName;
    }

    private void appendParagraph(StringBuilder builder, String content) {
        builder.append("<p>")
               .append(LF)
               .append(content)
               .append(LF)
               .append("</p>")
               .append(LF);
    }

}
