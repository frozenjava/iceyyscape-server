

package icedice.io.packets;


import icedice.Engine;
import icedice.npcs.NPC;
import icedice.util.Misc;
import icedice.players.Player;


public class NPCOption2 implements Packet {

    public static int randomCrap[] = {3759, 3761, 3763, 3765, 3777, 3779, 3781, 3783, 3785, 3787, 775, 3789, 1067, 1069, 1071, 1115, 1117, 1119, 1137, 1837, 1139, 1141, 1153, 1155, 1157, 1191, 1193, 1189, 1321, 1323, 1325, 1704, 1704, 1704};

    public static int Crap() {
        return randomCrap[(int) (Math.random() * randomCrap.length)];
    }

    public static int randomNice[] = {3140, 1087, 1305, 4087, 775, 6585, 11283, 4708, 4151, 4151, 4710, 4712, 4714, 4587, 4587, 4716, 1305, 4718, 4720, 4722, 4724, 4726, 4728, 4730, 4732, 4734, 4736, 4738, 4745, 4747, 4749, 4751, 4753, 4755, 4757, 4759, 6920, 6922, 6918, 11335, 6916, 6914, 6924};

    public static int Nice() {
        return randomNice[(int) (Math.random() * randomNice.length)];
    }

    public static int randomGood[] = {1077, 1079, 1125, 2653, 2655, 2657, 2659, 2661, 1305, 2663, 2665, 2667, 2669, 2671, 2673, 6568, 2675, 1127, 2643, 1147, 1151, 1149, 1163, 1165, 1199, 1201, 1331, 1333, 775, 6585, 6920, 6922, 6918, 6916, 6914, 6924};

    public static int Good() {
        return randomGood[(int) (Math.random() * randomGood.length)];
    }

    public static int randomMed[] = {1073, 1075, 1121, 1123, 1143, 2643, 1145, 1159, 1161, 6568, 1195, 1197, 1327, 1329, 10442, 10444, 10446, 1837, 775, 10448, 10450, 10452, 10454, 10456, 10458, 10460, 10462, 10464, 10466, 10468, 10470, 10472, 10474};

    public static int Med() {
        return randomMed[(int) (Math.random() * randomMed.length)];
    }

    /**
     * Handles the second NPC option.
     *
     * @param p          The Player which the frame should be handled for.
     * @param packetId   The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        if (!p.npcOption2) {
            int npcId = p.stream.readUnsignedWordBigEndianA();
            p.requestFaceTo(npcId);
            p.wc.resetWoodcutting();
            p.mi.resetMining();
            if (npcId <= 0 || npcId >= Engine.npcs.length
                    || Engine.npcs[npcId] == null) {
                return;
            }
            p.clickId = npcId;

            p.clickX = Engine.npcs[npcId].absX;
            p.clickY = Engine.npcs[npcId].absY;
            if (Misc.getDistance(p.absX, p.absY, p.clickX, p.clickY) > 30) {
                return;
            }
            p.npcOption2 = true;
        }
        if (p.clickId <= 0 || p.clickId >= Engine.npcs.length
                || Engine.npcs[p.clickId] == null) {
            p.npcOption2 = false;
            return;
        }
        if (Misc.getDistance(p.absX, p.absY, p.clickX, p.clickY) > 1) {
            return;
        }

        p.npcOption2 = false;

        NPC pnp = Engine.npcs[p.clickId];
        NPC np = Engine.npcs[p.FamiliarID];

        if (pnp.npcType == 6901) {
            p.frames.showChatboxInterface(p, 241);
            p.frames.animateInterfaceId(p, 9850, 241, 2);
            p.frames.setNPCId(p, 6901, 241, 2);
            p.frames.setString(p, "Dragon", 241, 3);
            p.frames.setString(p, "Rawr...I'm a dragon...", 241, 4);
        }
        if (pnp.npcType == 6528) {
            p.frames.showInterface(p, 105);
        }

        if (pnp.npcType == 6529) {
            p.frames.showInterface(p, 105);
        }

        if (pnp.npcType == 6530) {
            p.frames.showInterface(p, 105);
        }

        if (pnp.npcType == 6526) {
            p.frames.showInterface(p, 642);
        }

        if (pnp.npcType == 6531) {
            p.frames.showInterface(p, 105);
        }

        if (pnp.npcType == 6903) {
            p.frames.showChatboxInterface(p, 241);
            p.frames.animateInterfaceId(p, 9850, 241, 2);
            p.frames.setNPCId(p, 6903, 241, 2);
            p.frames.setString(p, "Dragon", 241, 3);
            p.frames.setString(p, "Rawr...I'm a dragon...", 241, 4);
        }

        if (pnp.npcType == 6905) {
            p.frames.showChatboxInterface(p, 241);
            p.frames.animateInterfaceId(p, 9850, 241, 2);
            p.frames.setNPCId(p, 6905, 241, 2);
            p.frames.setString(p, "Dragon", 241, 3);
            p.frames.setString(p, "Rawr...I'm a dragon...", 241, 4);
        }
        if (pnp.npcType == 768) {
            p.frames.showChatboxInterface(p, 241);
            p.frames.animateInterfaceId(p, 768, 241, 2);
            p.frames.setNPCId(p, 768, 241, 2);
            p.frames.setString(p, "Cat", 241, 3);
            p.frames.setString(p, "Miaaaauuw..", 241, 4);
        }
        if (pnp.npcType == 6907) {
            p.frames.showChatboxInterface(p, 241);
            p.frames.animateInterfaceId(p, 9850, 241, 2);
            p.frames.setNPCId(p, 6907, 241, 2);
            p.frames.setString(p, "Baby Black Dragon", 241, 3);
            p.frames.setString(p, "Rawr...I'm a dragon...", 241, 4);
        }

        if (pnp.npcType == 521) {//fally genral store
            Engine.shopHandler.openshop(p, 2);
        }
        if (pnp.npcType == 528) {//fally genral store
            Engine.shopHandler.openshop(p, 2);
        }
        if (pnp.npcType == 1780) { //beginers shop
            Engine.shopHandler.openshop(p, 4);
        }
        if (pnp.npcType == 538) {//barrows shop
            Engine.shopHandler.openshop(p, 13);
        }

        if (pnp.npcType == 520) { // beginers shop
            Engine.shopHandler.openshop(p, 4);
        }
        if (pnp.npcType == 520) {//melee shop
            Engine.shopHandler.openshop(p, 6);
        }
        if (pnp.npcType == 594) {//Fancy Shop
            Engine.shopHandler.openshop(p, 12);
        }
        if (pnp.npcType == 548) {//clothing store
            Engine.shopHandler.openshop(p, 14);
        }
        if (pnp.npcType == 549) {//armour shop
            Engine.shopHandler.openshop(p, 15);
        }
        if (pnp.npcType == 551) {//pot shop
            Engine.shopHandler.openshop(p, 16);
        }
        if (pnp.npcType == 554) {//darmour shop
            Engine.shopHandler.openshop(p, 17);
        }
        if (pnp.npcType == 550) {//ranged shop
            Engine.shopHandler.openshop(p, 18);
        }
        if (pnp.npcType == 587) {//herb shop
            Engine.shopHandler.openshop(p, 20);
        }
        if (pnp.npcType == 522) {//donators ranged shop
            Engine.shopHandler.openshop(p, 21);
        }
        if (pnp.npcType == 682) {//ranged armour shop
            Engine.shopHandler.openshop(p, 22);
        }
        if (pnp.npcType == 6970) {//ranged armour shop
            Engine.shopHandler.openshop(p, 23);
        }

        if (pnp.npcType == 598) {
            if (p.gender == 0) {
                p.frames.showInterface(p, 596);
            } else {
                p.frames.showInterface(p, 592);
            }
        }


        if (pnp.npcType == 7605) {
            p.openBank();
        }
        if (pnp.npcType == 7468) {
            Engine.playerItems.addItem(p, 3481, 1);
            Engine.playerItems.addItem(p, 3483, 1);
            Engine.playerItems.addItem(p, 3485, 1);
            Engine.playerItems.addItem(p, 3486, 1);
            Engine.playerItems.addItem(p, 3488, 1);
            Engine.playerItems.addItem(p, 1333, 1);
            Engine.playerItems.addItem(p, 1837, 1);
            Engine.playerItems.addItem(p, 6629, 1);
            Engine.playerItems.addItem(p, 1725, 1);
            Engine.playerItems.addItem(p, 6735, 1);
            Engine.playerItems.addItem(p, 1052, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            p.frames.sendMessage(p, "<img=1><col=FF0000>Take this stuff. I'm sure you can find more use for it then me!<img=1>");
        }

        if (pnp.npcType == 2398) {
            Engine.playerItems.addItem(p, 1917, 1);
            p.frames.sendMessage(p, "<img=1><col=FF0000>Here you go mate! Drink up!<img=1>");
        }

        if (pnp.npcType == 1918) {
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            Engine.playerItems.addItem(p, 391, 1);
            p.frames.sendMessage(p, "<img=1><col=FF0000>Take this extra food. It was lying around anywase!<img=1>");
        }


        if (pnp.npcType == 316) {
//Bait Trout
            if (p.ActionTimer == 0) {
                if (p.skillLvl[10] > 14) {
                    if (Engine.playerItems.HasItemAmount(p, 307, 1) == true) {
                        p.FishXP = 62;
                        p.FishGet = 335;
                        p.FishEmote = 622;
                        p.FishThat(p, p.FishXP, p.FishGet, p.FishEmote);
                    } else {
                        p.frames.sendMessage(p, "You need a fishing rod to fish here.");
                    }
                } else {
                    p.frames.sendMessage(p, "You need level 15 fishing to fish here.");
                }
            }
        }


        if (pnp.npcType == 312) {
//Harpoon Shark
            if (p.ActionTimer == 0) {
                if (p.skillLvl[10] > 74) {
                    if (Engine.playerItems.HasItemAmount(p, 311, 1) == true) {
                        p.FishXP = 150;
                        p.FishGet = 383;
                        p.FishEmote = 618;
                        p.FishThat(p, p.FishXP, p.FishGet, p.FishEmote);
                    } else {
                        p.frames.sendMessage(p, "You need a harpoon to fish here.");
                    }
                } else {
                    p.frames.sendMessage(p, "You need level 75 fishing to fish here.");
                }
            }
        }

        if (pnp.npcType == 313) {
//Harpoon Manta
            if (p.ActionTimer == 0) {
                if (p.skillLvl[10] > 89) {
                    if (Engine.playerItems.HasItemAmount(p, 311, 1) == true) {
                        p.FishXP = 200;
                        p.FishGet = 389;
                        p.FishEmote = 618;
                        p.FishThat(p, p.FishXP, p.FishGet, p.FishEmote);
                    } else {
                        p.frames.sendMessage(p, "You need a harpoon to fish here.");
                    }
                } else {
                    p.frames.sendMessage(p, "You need level 90 fishing to fish here.");
                }
            }
        }
//======================THIEVING================

        if (pnp.npcType == 20) {
            if (p.skillLvl[17] > 82) {
                if (p.ActionTimer == 0) {
                    p.ActionTimer = 3;
                    p.requestAnim(881, 0);
                    Engine.playerItems.addItem(p, 995, 100 + Misc.random(10));
                    p.frames.sendMessage(p, "You pickpocket the Paladin.");
                    p.addSkillXP(300 * p.skillLvl[17], 17);
                }
            } else {
                p.frames.sendMessage(p, "You need 83 Thieving to steal from him.");
            }
        }


        if (pnp.npcType == 32) {
            if (p.skillLvl[17] > 26) {
                if (p.ActionTimer == 0) {
                    p.ActionTimer = 3;
                    p.requestAnim(881, 0);
                    Engine.playerItems.addItem(p, 995, 70 + Misc.random(10));
                    p.frames.sendMessage(p, "You pickpocket gaurd.");
                    p.addSkillXP(300 * p.skillLvl[17], 17);
                }
            } else {
                p.frames.sendMessage(p, "You need 26 Thieving to steal from him.");
            }
        }

        if (pnp.npcType == 21) {
            if (p.skillLvl[17] > 64) {
                if (p.ActionTimer == 0) {
                    p.ActionTimer = 3;
                    p.requestAnim(881, 0);
                    Engine.playerItems.addItem(p, 995, 100 + Misc.random(6));
                    p.frames.sendMessage(p, "You pickpocket the Hero.");
                    p.addSkillXP(150 * p.skillLvl[17], 17);
                }
            } else {
                p.frames.sendMessage(p, "You need 65 Thieving to steal from him.");
            }
        }


        if (pnp.npcType == 5920) {
            if (p.skillLvl[17] > 40) {
                if (p.ActionTimer == 0) {
                    p.ActionTimer = 3;
                    p.requestAnim(881, 0);
                    Engine.playerItems.addItem(p, 995, 70 + Misc.random(6));
                    p.frames.sendMessage(p, "You pickpocket the Guard.");
                    p.addSkillXP(20 * p.skillLvl[17], 17);
                }
            } else {
                p.frames.sendMessage(p, "You need 40 Thieving to steal from him.");
            }
        }


        if (pnp.npcType == 1 || pnp.npcType == 9) {
            if (p.ActionTimer == 0) {
                p.ActionTimer = 3;
                p.requestAnim(881, 0);
                Engine.playerItems.addItem(p, 995, 1 + Misc.random(2));
                p.frames.sendMessage(p, "You pickpocket the Man.");
                p.addSkillXP(30 * p.skillLvl[17], 17);
            }
        }
        if (pnp.npcType == 2234) {
            if (p.skillLvl[17] > 39) {
                if (p.ActionTimer == 0) {
                    p.ActionTimer = 3;
                    p.requestAnim(881, 0);
                    Engine.playerItems.addItem(p, 995, 1 + Misc.random(4));
                    p.frames.sendMessage(p, "You pickpocket the farmer.");
                    p.addSkillXP(75 * p.skillLvl[17], 17);
                }
            } else {
                p.frames.sendMessage(p, "You need 40 Thieving to steal from him.");
            }
        }

        if (pnp.npcType == 2270 || pnp.npcType == 2619) {
            p.openBank();
        }

//===============END OF THIEVING=============================================
        if (pnp.npcType == 494 || pnp.npcType == 495) {
            p.openBank();
        }

        return;
    }


}
