package com.sincred.assembly.response.common;


public class StatusCodes {
    private StatusCodes() {
    }
    public static final class Success {
        public static class Meeting {
            private Meeting() {}
            public static final CommonResponse NewMeetingSuccessfullyRegistered = new CommonResponse(1L, "New Meeting Successfully Registered!", false);
        }
    }

    public static final class Error {
        private Error() {}

        public static class Meeting {
            private Meeting() {}
            public static final CommonResponse MeetingClosed = new CommonResponse(-1L, "Meeting closed", true);
            public static final CommonResponse MeetingNotFound = new CommonResponse(-2L, "Meeting not found", true);
        }

        public static class AssociatedVote {
            private AssociatedVote() {}
            public static final CommonResponse CpfAlreadyExists = new CommonResponse(-1L, "Cpf already exists", true);
        }

        public static class Util {
            private Util() {}
            public static final CommonResponse InvalidDate = new CommonResponse(-1L, "Invalid date", true);
            public static final CommonResponse DocumentInvalid = new CommonResponse(-2L, "Document invalid", true);
        }

    }
}
