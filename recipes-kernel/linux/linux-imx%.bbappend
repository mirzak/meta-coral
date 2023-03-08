FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

FILESPATH =. "${FILE_DIRNAME}/${BPN}-5.15:"

SRC_URI:append:coral-dev = "\
    file://0001-imx8mq-phanbell.dts-Enable-Coral-specifics-e.g.-PCIE.patch \
    file://0002-MLK-15307-2-clk-imx8mq-set-the-parent-clocks-of-PCIE.patch \
    file://0003-PCI-imx-Use-the-external-clock-as-REF_CLK-when-neede.patch \
    file://0004-PCI-imx-Provide-a-clock-to-the-device-for-i.MX8MQ.patch \
    file://extra.cfg \
    file://wifi.cfg \
"
