package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 *
 * @author tzschernitz
 */
@Entity(name = "Game")
@Table(name = "game") // case sensitive!
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "date_played")
    private LocalDate datePlayed;

    @Column(name = "buy_in_paid")
    private int buyInPaid;

    @Column(name = "rebuy_paid")
    private int rebuyPaid;

    @Column(name = "money_won")
    private int moneyWon;

    @Column(name = "position_finished")
    private int positionFinished;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id_fk"))
    private User user;

    public Game() {
    }

    public Game(LocalDate datePlayed, int buyInPaid, int rebuyPaid, int moneyWon, int positionFinished, User user) {
        this.datePlayed = datePlayed;
        this.buyInPaid = buyInPaid;
        this.rebuyPaid = rebuyPaid;
        this.moneyWon = moneyWon;
        this.positionFinished = positionFinished;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(LocalDate datePlayed) {
        this.datePlayed = datePlayed;
    }

    public int getBuyInPaid() {
        return buyInPaid;
    }

    public void setBuyInPaid(int buyInPaid) {
        this.buyInPaid = buyInPaid;
    }

    public int getRebuyPaid() {
        return rebuyPaid;
    }

    public void setRebuyPaid(int rebuyPaid) {
        this.rebuyPaid = rebuyPaid;
    }

    public int getMoneyWon() {
        return moneyWon;
    }

    public void setMoneyWon(int moneyWon) {
        this.moneyWon = moneyWon;
    }

    public int getPositionFinished() {
        return positionFinished;
    }

    public void setPositionFinished(int positionFinished) {
        this.positionFinished = positionFinished;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", datePlayed=" + datePlayed +
                ", buyInPaid=" + buyInPaid +
                ", rebuyPaid=" + rebuyPaid +
                ", moneyWon=" + moneyWon +
                ", positionFinished=" + positionFinished +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id &&
                buyInPaid == game.buyInPaid &&
                rebuyPaid == game.rebuyPaid &&
                moneyWon == game.moneyWon &&
                positionFinished == game.positionFinished &&
                Objects.equals(datePlayed, game.datePlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datePlayed, buyInPaid, rebuyPaid, moneyWon, positionFinished, user);
    }
}
