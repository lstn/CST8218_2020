/*
 * CST8218 Assignment 2
 * Author: Lucas Estienne <esti0011@algonquinlive.com>
 * 2020W Term
 */
package cst8218.esti0011.game;

import cst8218.esti0011.entity.Sprite;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author tgk
 */
@Stateful
public class SpriteSession implements SpriteSessionRemote {

    public static final Random random = new Random();
    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    @EJB
    private SpriteGame spriteGame;

    public List<Sprite> getSpriteList() {
        return spriteGame.getSpriteList();
    }

    @Override
    public void newSprite(MouseEvent event) {
        spriteGame.newSprite(event, color);
    }
    @Override
    public int getHeight() {
        return spriteGame.HEIGHT;
    }
    @Override
    public int getWidth() {
        return spriteGame.WIDTH;
    }
}
