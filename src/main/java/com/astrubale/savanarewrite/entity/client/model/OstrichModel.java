// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package com.astrubale.savanarewrite.entity.client.model;

import com.astrubale.savanarewrite.entity.custom.OstrichEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class OstrichModel<T extends OstrichEntity> extends SinglePartEntityModel<T> {
	private final ModelPart ostrich;
	private final ModelPart head;

	public OstrichModel(ModelPart root) {
		this.ostrich = root.getChild("ostrich");
		this.head = ostrich.getChild("body").getChild("head").getChild("neck").getChild("neck2");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData ostrich = modelPartData.addChild("ostrich", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = ostrich.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -17.0F, 2.25F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -26.0F, -6.0F, 11.0F, 9.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 17.0F, -2.25F));

		ModelPartData base = torso.addChild("base", ModelPartBuilder.create().uv(33, 33).cuboid(-3.5F, -3.0F, -1.5F, 7.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -21.0F, -7.5F));

		ModelPartData wings = body.addChild("wings", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 17.0F, -2.25F));

		ModelPartData leftWing = wings.addChild("leftWing", ModelPartBuilder.create(), ModelTransform.pivot(-4.8F, -21.5F, -1.8F));

		ModelPartData leftWing_r1 = leftWing.addChild("leftWing_r1", ModelPartBuilder.create().uv(18, 23).cuboid(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-1.2F, 2.5F, 0.8F, 0.0F, -0.3491F, 0.0F));

		ModelPartData rightWing = wings.addChild("rightWing", ModelPartBuilder.create(), ModelTransform.pivot(5.6F, -21.5F, -2.0F));

		ModelPartData rightWing_r1 = rightWing.addChild("rightWing_r1", ModelPartBuilder.create().uv(0, 23).cuboid(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.4F, 2.5F, 1.0F, 0.0F, 0.3491F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -5.85F, 5.45F));

		ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(34, 42).cuboid(-3.0F, -6.0F, -1.0F, 4.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 4.85F, 3.3F, 0.48F, 0.0F, 0.0F));

		ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.25F));

		ModelPartData left = legs.addChild("left", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, 0.0F, 0.0F));

		ModelPartData firsthalf = left.addChild("firsthalf", ModelPartBuilder.create().uv(18, 36).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData secondhalf = left.addChild("secondhalf", ModelPartBuilder.create().uv(26, 40).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

		ModelPartData foot = left.addChild("foot", ModelPartBuilder.create().uv(10, 23).cuboid(-1.0F, 0.0F, -3.5F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 15.0F, 0.5F));

		ModelPartData right = legs.addChild("right", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 0.0F, 0.0F));

		ModelPartData firsthalf2 = right.addChild("firsthalf2", ModelPartBuilder.create().uv(10, 36).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData secondhalf2 = right.addChild("secondhalf2", ModelPartBuilder.create().uv(36, 23).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

		ModelPartData foot2 = right.addChild("foot2", ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 15.5F, -1.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 17.0F, -2.25F));

		ModelPartData neck = head.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -21.0F, -9.0F));

		ModelPartData neck1 = neck.addChild("neck1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData neck2 = neck.addChild("neck2", ModelPartBuilder.create().uv(0, 36).cuboid(-1.5F, -8.0F, -2.0F, 3.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, -4.0F));

		ModelPartData neck3 = neck2.addChild("neck3", ModelPartBuilder.create().uv(36, 0).cuboid(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, -1.0F));

		ModelPartData beak = neck3.addChild("beak", ModelPartBuilder.create().uv(36, 10).cuboid(-1.0F, -32.0F, -16.0F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 26.0F, 12.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(OstrichEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		ostrich.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return ostrich;
	}
}