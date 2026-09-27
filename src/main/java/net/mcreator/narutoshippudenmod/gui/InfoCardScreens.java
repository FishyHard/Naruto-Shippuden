package net.mcreator.narutoshippudenmod.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardDojutsuGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardMiniGameGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardMissionsGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardUpgradeGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.StatSelectGui;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DiplayFumaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DiplayHoshigakiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DiplayHozukiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DiplayIzunoSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DiplayKaguyaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DiplaySarutobiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display10MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display11MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display12MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display13MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display14MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display15MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display16MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display17MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display18MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display19MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display1MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display20MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display21MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display22MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display23MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display24MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display25MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display26MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display27MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display28MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display29MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display2MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display30MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display31MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display32MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display33MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display34MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display35MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display36MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display37MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display38MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display39MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display3MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display40MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display41MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display42MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display43MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display44MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display45MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display46MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display47MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display48MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display4MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display5MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display6MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display7MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display8MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Display9MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayAburameInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayAburameSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayAkimichiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayAkimichiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayBoilInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayBoneInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayByakugan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayByakugan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayByakugan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayByakugan2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayByakuganActivated2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayByakuganActivated2x2Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayByakuganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayChinoikeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayChinoikeSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayCloudSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayDustInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayEarthInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayEarthSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayFireInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayFireSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayFumaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayHatakeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayHatakeSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayHoshigakiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayHozukiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayHyugaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayHyugaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIburiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIburiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIceInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayInuzukaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayInuzukaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIsshikiDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIsshikiDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIsshikiDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIsshikiDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIsshikiDojutsuInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayItachiDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayItachiDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayItachiDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayItachiDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayIzunoInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKaguyaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKakashi1Dojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKakashi1Dojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKakashi1Dojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKakashi1Dojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKakashiDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKakashiDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKakashiDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKakashiDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKazekageInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKazekageSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKetsuryugan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKetsuryugan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKetsuryugan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKetsuryugan2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKetsuryuganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKonohaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKuramaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayKuramaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayLeeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayLeeSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayLightningInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayLightningSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMSItachiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMSMadaraInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMSObitoInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMSSasukeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMSShisuiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMadaraDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMadaraDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMadaraDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMadaraDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMagnetInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMarcus2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMarcus2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMarcus2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMarcus2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMinus2SelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayMistSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayNamikazeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayNamikazeSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayNaraInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayNaraSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayObitoDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayObitoDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayObitoDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayObitoDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayOtsutsukiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayOtsutsukiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayRinnegan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayRinnegan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayRinnegan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayRinnegan2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayRinneganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySandSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySarutobiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySasukeDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySasukeDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySasukeDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySasukeDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayScarProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySenjuInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySenjuSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySharingan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySharingan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySharingan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySharingan2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySharinganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayShimuraInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayShimuraSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayShisuiDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayShisuiDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayShisuiDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayShisuiDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySmokeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySteelInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayStoneSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayStormInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplaySwiftInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTenroInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTenroSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTenseigan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTenseigan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTenseigan2x21Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTenseigan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTenseiganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTsuchigumoInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTsuchigumoSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayTyphoonInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayUchihaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayUchihaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayUzumakiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayUzumakiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayVoltic2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayVoltic2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayVoltic2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayVoltic2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayWaterInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayWaterSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayWindInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayWindSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayWoodInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayYukiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayYukiSelectProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class InfoCardScreens {
	private InfoCardScreens() {
	}

	@OnlyIn(Dist.CLIENT)
	public static class InfoCardDojutsuGuiWindow extends ContainerScreen<InfoCardDojutsuGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = InfoCardDojutsuGui.guistate;

		public InfoCardDojutsuGuiWindow(InfoCardDojutsuGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();

			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_dojutsu_texture.png"));
			this.blit(ms, this.guiLeft + -126, this.guiTop + -39, 0, 0, 350, 250, 350, 250);

			if (DisplaySharingan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan2px1px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplaySharingan2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan2px2px1gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplaySharingan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan2px2px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplaySharingan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan2px1pxgui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayByakugan2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_2x2_pupils_1x2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayByakugan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_2x2_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayByakugan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_2x1_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayByakugan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_2x1_pupils_2x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayByakuganActivated2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_activated_gui.png"));
				this.blit(ms, this.guiLeft + -99, this.guiTop + 59, 0, 0, 125, 52, 125, 52);
			}
			if (DisplayByakuganActivated2x2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_activated_gui.png"));
				this.blit(ms, this.guiLeft + -99, this.guiTop + 74, 0, 0, 125, 52, 125, 52);
			}
			if (DisplayKetsuryugan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan_2x1_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayKetsuryugan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan_2x1_pupils_2x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayKetsuryugan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan_2x2_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayKetsuryugan2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan_2x2_pupils_1x2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayIsshikiDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu_2x1_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayIsshikiDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu_2x1_pupils_2x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayIsshikiDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu_2x2_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayIsshikiDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu_2x2_pupils_1x2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayVoltic2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/voltic_mode_2x1_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayVoltic2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/voltic_mode_2x1_pupils_2x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayVoltic2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/voltic_mode_2x2_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayVoltic2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/voltic_mode_2x2_pupils_1x2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplaySasukeDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sasukemangekyo2px2px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplaySasukeDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sasukemangekyo2px2px1gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplaySasukeDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sasukemangekyo2px1px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplaySasukeDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sasukemangekyo2px1pxgui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayItachiDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/itachimangekyo2px1pxgui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayItachiDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/itachimangekyo2px1px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayItachiDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/itachimangekyo2px2px1gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayItachiDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/itachimangekyo2px2px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayMadaraDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/madaramangekyo2px1pxgui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayMadaraDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/madaramangekyo2px1px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayMadaraDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/madaramangekyo2px2px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayMadaraDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/madaramangekyo2px2px1gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayObitoDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/obitomangekyo2px1pxgui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayObitoDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/obitomangekyo2px1px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayObitoDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/obitomangekyo2px2px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayObitoDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/obitomangekyo2px2px1gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayShisuiDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shisuimangekyo2px1pxgui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayShisuiDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shisuimangekyo2px1px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayShisuiDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shisuimangekyo2px2px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayShisuiDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shisuimangekyo2px2px1gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayScarProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/scargui.png"));
				this.blit(ms, this.guiLeft + -21, this.guiTop + 49, 0, 0, 32, 78, 32, 78);
			}
			if (DisplayKakashi1Dojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashisharingan2px1px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayKakashi1Dojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashisharingan2px1pxgui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayKakashi1Dojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashisharingan2px2px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayKakashi1Dojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashisharingan2px2px1gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayKakashiDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashimangekyo2px1pxgui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayKakashiDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashimangekyo2px1px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayKakashiDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashimangekyo2px2px2gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayKakashiDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashimangekyo2px2px1gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayMarcus2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/furamingogan_2x1_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayMarcus2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/furamingogan_2x1_pupils_2x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayMarcus2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/furamingogan_2x2_pupils_1x1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayMarcus2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/furamingogan_2x2_pupils_1x2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayRinnegan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan2px1px_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayRinnegan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan2px1px2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayRinnegan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan2px2px1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayRinnegan2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan2px2px2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayTenseigan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan2px1px_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayTenseigan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan1px2px2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
			}
			if (DisplayTenseigan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan2px2px2_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			if (DisplayTenseigan2x21Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan2px2px1_gui.png"));
				this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
			}
			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
			this.font.drawString(ms, "Dojutsu", 42, 35, -16777216);
			this.font.drawString(ms, "Pupils Height", 42, 65, -16777216);
			this.font.drawString(ms, "Eyes Height", 41, 93, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).Eyes_Height) + "", 149, 93, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).Pupils_Height) + "", 149, 66, -16777216);
			this.font.drawString(ms, "" + (NarutoShippudenModVariables.get(entity).DojutsuSelectResize) + "", 109, 35, -16777216);
			if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				this.font.drawString(ms, "" + (NarutoShippudenModVariables.get(entity).DojutsuSelect2) + "", 126, 3, -16777216);
			this.font.drawString(ms, "" + (NarutoShippudenModVariables.get(entity).DojutsuSelect3) + "", 109, 44, -16777216);
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + -13, this.guiTop + -20, 56, 20, new StringTextComponent("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(0, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 87, this.guiTop + 30, 20, 20, new StringTextComponent("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(1, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 184, this.guiTop + 30, 20, 20, new StringTextComponent(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(2, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 117, this.guiTop + 60, 20, 20, new StringTextComponent("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(3, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 3, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 166, this.guiTop + 60, 20, 20, new StringTextComponent(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(4, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 4, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 117, this.guiTop + 88, 20, 20, new StringTextComponent("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(5, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 5, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 166, this.guiTop + 88, 20, 20, new StringTextComponent(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(6, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 6, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -65, this.guiTop + 165, 56, 20, new StringTextComponent("Select"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(7, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 7, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 87, this.guiTop + -2, 20, 20, new StringTextComponent("<"), e -> {
				if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(8, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 8, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 184, this.guiTop + -2, 20, 20, new StringTextComponent(">"), e -> {
				if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(9, x, y, z));
					InfoCardDojutsuGui.handleButtonAction(entity, 9, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class InfoCardGuiWindow extends ContainerScreen<InfoCardGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = InfoCardGui.guistate;

		public InfoCardGuiWindow(InfoCardGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();

			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_texture.png"));
			this.blit(ms, this.guiLeft + -126, this.guiTop + -39, 0, 0, 350, 250, 350, 250);

			if (DisplayAburameInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/aburame.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayAkimichiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/akimichi.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayChinoikeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/chinoike.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayHatakeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hatake.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayHyugaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hyuga.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayIburiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/iburi.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayInuzukaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/inuzuka.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayKazekageInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kazekage.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayLeeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/lee.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayNamikazeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/namikaze.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayNaraInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/nara.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayOtsutsukiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/otsutsuki.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplaySenjuInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/senju.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayShimuraInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shimura.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayTenroInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenro.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayTsuchigumoInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tsuchigumo.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayUchihaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/uchiha.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayUzumakiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/uzumaki.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayYukiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/yuki.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayFireInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/fire_release_info.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayLightningInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/lightning_release_info.png"));
				this.blit(ms, this.guiLeft + 76, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayWindInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/wind_release_info.png"));
				this.blit(ms, this.guiLeft + 95, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayWaterInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/water_release_info.png"));
				this.blit(ms, this.guiLeft + 114, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayEarthInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/earth_release_info.png"));
				this.blit(ms, this.guiLeft + 133, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayFumaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/fuuma.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayHoshigakiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hoshigaki.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayHozukiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hozuki.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayIzunoInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/izuno.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayKaguyaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kaguya.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayKuramaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kurama_clan.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplaySarutobiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sarutobi.png"));
				this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayIceInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ice_release.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayWoodInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/wood_release.png"));
				this.blit(ms, this.guiLeft + 76, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayMagnetInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/magnet_release.png"));
				this.blit(ms, this.guiLeft + 95, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayStormInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/storm_release.png"));
				this.blit(ms, this.guiLeft + 114, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
			}
			if (DisplaySmokeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/smoke_release.png"));
				this.blit(ms, this.guiLeft + 133, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
			}
			if (DisplaySteelInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/steel_release.png"));
				this.blit(ms, this.guiLeft + 152, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayBoilInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/boil_release.png"));
				this.blit(ms, this.guiLeft + 171, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayBoneInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/bone_release.png"));
				this.blit(ms, this.guiLeft + 190, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
			}
			if (DisplaySwiftInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/swift_release.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 32, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayTyphoonInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/typhoon_release.png"));
				this.blit(ms, this.guiLeft + 76, this.guiTop + 32, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayDustInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/dust_release.png"));
				this.blit(ms, this.guiLeft + 95, this.guiTop + 32, 0, 0, 16, 16, 16, 16);
			}
			if (DisplaySharinganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 109, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayByakuganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan.png"));
				this.blit(ms, this.guiLeft + 76, this.guiTop + 109, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayKetsuryuganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan.png"));
				this.blit(ms, this.guiLeft + 95, this.guiTop + 109, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayMSItachiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_itachi.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayMSMadaraInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_madara.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayMSObitoInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_obito.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayMSSasukeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_sasuke.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayMSShisuiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_shisui.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayTenseiganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan.png"));
				this.blit(ms, this.guiLeft + 76, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayRinneganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + 71, 0, 0, 16, 16, 16, 16);
			}
			if (DisplayIsshikiDojutsuInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu.png"));
				this.blit(ms, this.guiLeft + 114, this.guiTop + 109, 0, 0, 16, 16, 16, 16);
			}
			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
			this.font.drawString(ms, "LvL XP Max:", 121, -13, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).sp) + "", 196, -23, -16777216);
			this.font.drawString(ms, "SP:", 179, -23, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).jp) + "", 138, -23, -16777216);
			this.font.drawString(ms, "JP:", 121, -23, -16777216);
			this.font.drawString(ms, "" + (NarutoShippudenModVariables.get(entity).rank) + "", -78, 118, -16777216);
			this.font.drawString(ms, "Level:", 52, -23, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).LEVELSTAT) + "", 85, -23, -16777216);
			this.font.drawString(ms, "LvL XP:", 52, -13, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).LEVEL) + "", 89, -13, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).LEVELMAX) + "", 180, -13, -16777216);
			this.font.drawString(ms, "" + (NarutoShippudenModVariables.get(entity).village) + "", -71, 87, -16777216);
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + -105, this.guiTop + 182, 68, 20, new StringTextComponent("Next Page"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(0, x, y, z));
					InfoCardGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -13, this.guiTop + -20, 56, 20, new StringTextComponent("Quests"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(1, x, y, z));
					InfoCardGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -13, this.guiTop + 5, 56, 20, new StringTextComponent("Mini Game"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(2, x, y, z));
					InfoCardGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -13, this.guiTop + 30, 56, 20, new StringTextComponent("Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(3, x, y, z));
					InfoCardGui.handleButtonAction(entity, 3, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -13, this.guiTop + 55, 56, 20, new StringTextComponent("Jutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(4, x, y, z));
					InfoCardGui.handleButtonAction(entity, 4, x, y, z);
				}
			}));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class InfoCardMiniGameGuiWindow extends ContainerScreen<InfoCardMiniGameGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = InfoCardMiniGameGui.guistate;

		public InfoCardMiniGameGuiWindow(InfoCardMiniGameGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();

			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_mini_game_texture.png"));
			this.blit(ms, this.guiLeft + 6, this.guiTop + 21, 0, 0, 162, 124, 162, 124);

			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
			this.font.drawString(ms, "LvL XP Max:", 134, 9, -1);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).LEVELMINIGAME) + "", 103, 9, -1);
			this.font.drawString(ms, "LvL XP:", 64, 9, -1);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) + "", 195, 9, -1);
			this.font.drawString(ms, "Level:", 64, -4, -1);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME) + "", 98, -4, -1);
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + 6, this.guiTop + -1, 56, 20, new StringTextComponent("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(0, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 27, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
				if (Display2MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(1, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 1, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display2MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 7, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
				if (Display9MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(2, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 2, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display9MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 7, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
				if (Display17MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(3, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 3, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display17MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 7, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
				if (Display25MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(4, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 4, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display25MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 7, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
				if (Display33MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(5, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 5, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display33MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 7, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
				if (Display41MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(6, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 6, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display41MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 7, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
				if (Display1MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(7, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 7, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display1MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 27, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
				if (Display10MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(8, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 8, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display10MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 27, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
				if (Display18MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(9, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 9, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display18MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 27, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
				if (Display26MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(10, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 10, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display26MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 27, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
				if (Display34MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(11, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 11, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display34MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 27, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
				if (Display42MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(12, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 12, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display42MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 47, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
				if (Display3MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(13, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 13, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display3MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 47, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
				if (Display11MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(14, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 14, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display11MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 47, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
				if (Display19MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(15, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 15, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display19MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 47, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
				if (Display27MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(16, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 16, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display27MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 47, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
				if (Display35MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(17, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 17, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display35MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 87, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
				if (Display5MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(18, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 18, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display5MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 67, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
				if (Display4MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(19, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 19, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display4MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 67, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
				if (Display12MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(20, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 20, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display12MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 67, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
				if (Display20MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(21, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 21, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display20MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 67, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
				if (Display28MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(22, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 22, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display28MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 67, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
				if (Display36MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(23, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 23, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display36MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 67, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
				if (Display44MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(24, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 24, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display44MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 47, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
				if (Display43MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(25, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 25, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display43MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 87, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
				if (Display13MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(26, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 26, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display13MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 87, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
				if (Display21MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(27, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 27, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display21MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 87, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
				if (Display29MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(28, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 28, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display29MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 87, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
				if (Display37MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(29, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 29, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display37MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 87, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
				if (Display45MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(30, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 30, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display45MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
				if (Display6MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(31, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 31, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display6MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
				if (Display14MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(32, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 32, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display14MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
				if (Display22MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(33, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 33, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display22MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
				if (Display30MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(34, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 34, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display30MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
				if (Display38MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(35, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 35, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display38MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
				if (Display46MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(36, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 36, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display46MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 127, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
				if (Display7MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(37, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 37, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display7MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 127, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
				if (Display15MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(38, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 38, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display15MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 127, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
				if (Display23MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(39, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 39, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display23MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 127, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
				if (Display31MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(40, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 40, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display31MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 127, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
				if (Display39MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(41, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 41, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display39MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 127, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
				if (Display47MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(42, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 42, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display47MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 147, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
				if (Display48MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(43, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 43, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display48MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 147, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
				if (Display40MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(44, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 44, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display40MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 147, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
				if (Display32MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(45, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 45, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display32MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 147, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
				if (Display24MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(46, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 46, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display24MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 147, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
				if (Display16MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(47, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 47, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display16MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 147, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
				if (Display8MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(48, x, y, z));
					InfoCardMiniGameGui.handleButtonAction(entity, 48, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Display8MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class InfoCardMissionsGuiWindow extends ContainerScreen<InfoCardMissionsGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = InfoCardMissionsGui.guistate;

		public InfoCardMissionsGuiWindow(InfoCardMissionsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();

			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card__missions_texture.png"));
			this.blit(ms, this.guiLeft + -126, this.guiTop + -39, 0, 0, 350, 250, 350, 250);

			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).D_Mission) + "", -90, 86, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).C_Mission) + "", -90, 105, -16776961);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).B_Mission) + "", -90, 123, -16711885);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).A_Mission) + "", -90, 143, -65536);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).S_Mission) + "", -90, 164, -26368);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).SS_Mission) + "", -85, 184, -256);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).Shinobi_Murder_Count) + "", 175, -12, -16777216);
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + -13, this.guiTop + -20, 56, 20, new StringTextComponent("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMissionsGui.ButtonPressedMessage(0, x, y, z));
					InfoCardMissionsGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class InfoCardUpgradeGuiWindow extends ContainerScreen<InfoCardUpgradeGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = InfoCardUpgradeGui.guistate;

		public InfoCardUpgradeGuiWindow(InfoCardUpgradeGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();

			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_upgrading_texture.png"));
			this.blit(ms, this.guiLeft + -126, this.guiTop + -39, 0, 0, 350, 250, 350, 250);

			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
			this.font.drawString(ms, "SP Use Count", -105, 64, -1);
			this.font.drawString(ms, "Selected:", -105, 74, -1);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).spusecount) + "", -55, 74, -1);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).ninjutsu) + "", 91, -22, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).taijutsu) + "", 91, 6, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).kenjutsu) + "", 91, 30, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).shurikenjutsu) + "", 115, 54, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).summoning) + "", 101, 77, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).kinjutsu) + "", 88, 102, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).senjutsu) + "", 93, 126, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).medicine) + "", 96, 150, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).speed) + "", 79, 174, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).jutsupowerstat) + "", 200, -21, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).genjutsu) + "", 188, 6, -16777216);
			this.font.drawString(ms, "" + (int) (NarutoShippudenModVariables.get(entity).IQ) + "", 154, 31, -16777216);
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + -105, this.guiTop + 182, 68, 20, new StringTextComponent("Previous Page"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(0, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -105, this.guiTop + 86, 22, 20, new StringTextComponent("1"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(1, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -83, this.guiTop + 86, 22, 20, new StringTextComponent("5"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(2, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -61, this.guiTop + 86, 22, 20, new StringTextComponent("10"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(3, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 3, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 76, this.guiTop + -28, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(4, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 4, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 76, this.guiTop + 0, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(5, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 5, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 76, this.guiTop + 24, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(6, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 6, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 100, this.guiTop + 48, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(7, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 7, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 85, this.guiTop + 71, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(8, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 8, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 75, this.guiTop + 96, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(9, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 9, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 76, this.guiTop + 120, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(10, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 10, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 78, this.guiTop + 144, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(11, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 11, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 62, this.guiTop + 168, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(12, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 12, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 187, this.guiTop + -28, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(13, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 13, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 170, this.guiTop + -1, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(14, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 14, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 139, this.guiTop + 24, 10, 20, new StringTextComponent("+"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(15, x, y, z));
					InfoCardUpgradeGui.handleButtonAction(entity, 15, x, y, z);
				}
			}));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class StatSelectGuiWindow extends ContainerScreen<StatSelectGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = StatSelectGui.guistate;

		public StatSelectGuiWindow(StatSelectGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			if (DisplayFireSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/fire_release.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayEarthSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/earth_release.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayLightningSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/lightning_release.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayWaterSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/water_release.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayWindSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/wind_release.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayUchihaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/uchiha.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayUzumakiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/uzumaki.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayHyugaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hyuga.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayHatakeSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hatake.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayIburiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/iburi.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayAburameSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/aburame.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayAkimichiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/akimichi.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayChinoikeSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/chinoike.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayInuzukaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/inuzuka.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayKazekageSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kazekage.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayLeeSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/lee.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayNamikazeSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/namikaze.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayNaraSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/nara.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayOtsutsukiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/otsutsuki.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplaySenjuSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/senju.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayTenroSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenro.png"));
				this.blit(ms, this.guiLeft + 57, this.guiTop + -20, 0, 0, 64, 64, 64, 64);
			}
			if (DisplayTsuchigumoSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tsuchigumo.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayYukiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/yuki.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayShimuraSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shimura.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayKonohaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/konohagakure.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayMistSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kirigakure.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayStoneSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/iwagakure.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayCloudSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kumogakure.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
			}
			if (DisplaySandSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sunagakure.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
			}
			if (DisplayKuramaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kurama_clan.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DiplaySarutobiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sarutobi.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DiplayFumaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/fuuma.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DiplayHoshigakiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hoshigaki.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DiplayHozukiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hozuki.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DiplayKaguyaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kaguya.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			if (DiplayIzunoSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/izuno.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
			}
			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
			this.font.drawString(ms, "Clan", 77, 24, -1);
			this.font.drawString(ms, "Village", 70, 66, -1);
			this.font.drawString(ms, "Nature", 72, 109, -1);
			this.font.drawString(ms, "Release", 70, 118, -1);
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + 55, this.guiTop + 0, 8, 20, new StringTextComponent("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(0, x, y, z));
					StatSelectGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 111, this.guiTop + 0, 8, 20, new StringTextComponent(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(1, x, y, z));
					StatSelectGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 55, this.guiTop + 40, 8, 20, new StringTextComponent("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(2, x, y, z));
					StatSelectGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 111, this.guiTop + 40, 8, 20, new StringTextComponent(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(3, x, y, z));
					StatSelectGui.handleButtonAction(entity, 3, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 59, this.guiTop + 140, 56, 20, new StringTextComponent("Select"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(4, x, y, z));
					StatSelectGui.handleButtonAction(entity, 4, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 55, this.guiTop + 84, 8, 20, new StringTextComponent("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(5, x, y, z));
					StatSelectGui.handleButtonAction(entity, 5, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 111, this.guiTop + 84, 8, 20, new StringTextComponent(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(6, x, y, z));
					StatSelectGui.handleButtonAction(entity, 6, x, y, z);
				}
			}));
		}
	}
}
