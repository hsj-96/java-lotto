package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.vo.RankCounts;

public class Statistics {

    private final LottoRanks lottoRanks;
    private final Map<LottoRank, Integer> rankCounts;

    public Statistics(final LottoRanks lottoRanks) {
        this.lottoRanks = lottoRanks;
        this.rankCounts = new LinkedHashMap<>();

        initRankCount();
    }

    private void initRankCount() {
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankCounts.put(rank, 0));
    }

    public RankCounts getRankCounts() {
        lottoRanks.get()
                .forEach(rank -> rankCounts.put(rank, rankCounts.get(rank) + 1));

        return new RankCounts(rankCounts);
    }

    public double getProfitRate() {
        final List<LottoRank> lottoRanks = this.lottoRanks.get();
        return lottoRanks.stream().mapToDouble(LottoRank::getAmount).sum() / (lottoRanks.size() * 1000);
    }
}
