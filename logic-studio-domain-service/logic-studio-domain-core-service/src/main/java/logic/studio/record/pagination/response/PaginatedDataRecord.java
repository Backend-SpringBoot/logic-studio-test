package logic.studio.record.pagination.response;

import java.util.List;
import lombok.Builder;

@Builder
public record PaginatedDataRecord<T>(
    List<T> data, long totalElements, int totalPages, int number, int size) {

  public PaginatedDataRecord<T> cloneAfterSave(List<T> newData) {
    return new PaginatedDataRecord<>(
        newData,
        totalElements,
        totalPages,
        number,
        size
    );
  }
  public boolean isFirst() {
    return number == 0;
  }

  public boolean isLast() {
    return number + 1 == totalPages;
  }

  public boolean hasContent() {
    return !data.isEmpty();
  }
}
